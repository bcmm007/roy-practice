# -*- coding: utf-8 -*-
fileSourcePath = '/Users/roy/Workspace/hrjlk-nlp/jieba/dt_hrjlk_cut_stop_words.dt'
fileCheckPath = '/Users/roy/Workspace/hrjlk-nlp/jieba/dt_hrjlk_stop_words.dt'
file dt_hrjlk_stop_words.dt

#从源文件中读取数据到集合
listSource = []
objFileSource = open(fileSourcePath,'r')
for lineSource in objFileSource:
    listSource.append(lineSource.replace('\n',''))

print(listSource)
#从对比文件读取数据到集合
listCheck = []
objFileCheck = open(fileCheckPath,'r')
for lineCheck in objFileCheck:
    listCheck.append(lineCheck.replace('\n',''))
print(listCheck)

#获得差异词

for word in listSource:
    if word in listCheck:
        print(word)




# -*- coding: utf-8 -*-
fileSourcePath = '/Users/roy/Workspace/hrjlk-nlp/jieba/dt_hrjlk_cut_stop_words.dt'
fileCheckPath = '/Users/roy/Workspace/hrjlk-nlp/jieba/dt_hrjlk_stop_words.dt'
fileTemp = '/Users/roy/Workspace/hrjlk-nlp/jieba/temp.dt'

#从源文件中读取数据到集合
listSource = []
objReadSource = open(fileSourcePath,'r')
for lineSource in objReadSource:
    listSource.append(lineSource.replace('\n',''))
objReadSource.close()
print(listSource)

#从对比文件读取数据到集合
listCheck = []
objReadCheck = open(fileCheckPath,'r')
for lineCheck in objReadCheck:
    listCheck.append(lineCheck.replace('\n',''))
objReadCheck.close()
print(listCheck)


#存储差异的集合
listDiff = []
for word in listSource:
    if word in listCheck:
        listDiff.append(word)

#开始删除数据
objWriteTemp = open(fileTemp,'w+')
for lineStop in listCheck:
    if lineStop in listDiff:
        continue;
    objWriteTemp.write(lineStop)
    objWriteTemp.write('\n')

objWriteTemp.close()



dt_hrjlk_stop_words.dt