import pandas as pd
import statsmodels.api as sm
import lxml
import xlsxwriter


workbook = xlsxwriter.Workbook('aa.xlsx')
worksheet1 = workbook.add_worksheet()

fb = pd.read_csv('corre.csv')

X = fb['MKT']
y = fb['ER']
z = fb['FundId']

worksheet1.write(0, 0, 'FundID')
worksheet1.write(0, 1, 'Alpha')
worksheet1.write(0, 2, 'Beta')

ab = 0
lenz = len(z)
mn = 1

while True:
    if ab+1 > lenz:
        break
    X1 = sm.add_constant(X[ab:ab+111])
    model = sm.OLS(y[ab:ab+111], X1)
    ab = ab + 111
    results = model.fit()
    df = pd.read_html(results.summary().tables[1].as_html(),header=0,index_col=0)[0]
    a=df['coef'].values[1]
    c=df['coef'].values[0]
    print(a)
    print(c)
    print(z[ab-68])
    worksheet1.write(mn, 0, z[ab-68])
    worksheet1.write(mn, 1, a)
    worksheet1.write(mn, 2, c)
    mn = mn + 1
    


workbook.close()


    
