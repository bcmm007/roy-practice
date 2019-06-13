#1.type
#2.metaclass(元类，或者叫类生成器)
#3.class(类，或者叫实例生成器)
#4.instance(实例)


#创建一个Hello类，拥有属性say_hello
class Hello():
    def say_hello(self, name='world'):
        print('Hello, %s.' % name)

#从Hello类创建一个实例hello
hello = Hello()
#使用hello调用方法say_hello
hello.say_hello()

#创建函数fn
def fn(self, name='world'):
    print('Hello, %s.' % name)
# 通过type创建Hello class;参数说明:类名映射,继承的类,方法映射
genHello = type('Hello', (object,), dict(say_hello=fn))


'''
元类的具体应用
'''
#继承自type
class SayMetaClass(type):
    #参数说明;将创建的类,类名,继承,方法与属性
    def __new__(cls, name, bases, attrs):
        attrs['say_'+name] = lambda self,value,saying=name: print(saying+','+value+'!')
        return type.__new__(cls, name, bases, attrs)

#因为继承自SayMetaClass,所以创建类时,动态添加了say_Hello
class Hello(object, metaclass=SayMetaClass):
    pass
#创建实列
hello = Hello()
#调用实例方法
hello.say_Hello('world!')


#应用二
class ListMetaclass(type):
    def __new__(cls, name, bases, attrs):
        attrs['add'] = lambda self, value: self.append(value)
        return type.__new__(cls, name, bases, attrs)

class MyList(list, metaclass=ListMetaclass):
    pass

L = MyList()
L.add(1)
