age = c(21,20,22,20,23,20,24,23,22,20,21,19,20,21,25,19,20,23,18,25,20,21,21,24,20,25,17,24,21,23,21,21,20,22,23,21,19,22,23,24,22,20,22,20,21,18,18,20)
mean(age)
sd(age)
boxplot(age, col='pink', xlab='Age en moyenne des étudiants de L2')
length(age)
hist(age, xlim=c(16,28), col = 'purple', xlab='Age des étudiants')
z = qnorm(0.975)
z
mean(age)-z*2/3
mean(age)+z*2/3
mean(age)-z*(sd(age)/sqrt(length(age)))
mean(age)+z*(sd(age)/sqrt(length(age)))
tableau=read.table(file.choose(), header = TRUE)
tableau
names(tableau)
tableau[tableau[,2]=A] 
dataA=tableau[tableau[,2]=='A',]
summary(dataA)
sum(dataA)
dataA
dataB=tableau[tableau[,2]=='B',]
dataB
mean(dataB$Note)
mean(dataA$Note)
pnorm(10,11,2)
qnorm(0.975)
dhyper(5,48,10,0.5)
