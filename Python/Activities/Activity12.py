def calculatorSum(num):
    if num:
        return num+calculatorSum(num-1)
    else:
        return num
    
res = calculatorSum(10)
print("Results :", res)



