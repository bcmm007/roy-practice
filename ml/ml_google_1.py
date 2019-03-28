from sklearn import tree

features = [[140,1],[130,1],[150,0],[170,0]]
lables = [0,0,1,1]
clf = tree.DecisionTreeClassifier()
clf = clf.fit(features,lables)
print(clf.predict([[180,0]]))



'sepal length (cm)', 'sepal width (cm)', 'petal length (cm)', 'petal width (cm)'
花萼的长度 花萼的宽度 花瓣的长度 花瓣的宽度
'setosa' 'versicolor' 'virginica'


from sklearn.datasets import load_iris
import numpy
from sklearn import tree

iris = load_iris()

print(iris.feature_names)
print(iris.target_names)
print(iris.data[0])
print(iris.target[0])

for i in range(len(iris.target)):
    print ('Example %d: label %s,features %s' % (i,iris.target[i],iris.data[i]))

#training data
train_target = np.delete(iris.target,test_idx)
train_data = np.delete(iris.data,test_idx,axis=0)

#test data
test_target = iris.target[test_idx]
test_data = iris.data[test_idx]

clf = tree.DecisionTreeClassifier()
clf = clf.fit(train_data,train_target)
print (clf.predict(test_data))

print test_target
print test_data