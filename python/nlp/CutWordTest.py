import os
import json
import jieba.analyse
import re

'''
格式化字符串，全角转半角
input:str
return:str
author:roy
dt:2019-05-18
'''
def tfQ2B(strOri):
    strB = ''
    #遍历所有字母
    for letter in strOri:
        charCode = ord(letter)
        #全角空格直接转换
        if charCode == 12288:
            charCode = 32
        elif charCode >= 65281 and charCode <= 65374:
            charCode = charCode - 65248
        strB = strB + chr(charCode)
    return strB

#path paramater
fileRootPath = '/Users/roy/MyApp/jd'
fileEnd = '.txt'
fileMinName = 'HangZhou-'
fileName = 'TeachAdmin'
fullPath = fileRootPath + os.sep + fileMinName + fileName + fileEnd

#load file text into a list
listJd = []
strJd = ''
for line in open(fullPath,'r',encoding='utf8'):  
    strRead = line.strip()
    if strRead == '}':
        listJd.append(json.loads(strJd + strRead))
        strJd = ''
    else:
        strJd = strJd + strRead

#load jieba config file
fileCutStopDt = '/Users/roy/Run/jieba-dict/dt_hrjlk_cut_stop_words.dt'
fileStopDt = '/Users/roy/Run/jieba-dict/dt_hrjlk_stop_words.dt'
fileKeyDt = '/Users/roy/Run/jieba-dict/dt_hrjlk_key_words.dt'
fileIdfKeyDt = '/Users/roy/Run/jieba-dict/dt_hrjlk_idf_words.dt'

#cut word user defiend
jieba.load_userdict(fileKeyDt)
#cut stop words
listMyCutStopWords = [line.split('\n')[0] for line in open(fileCutStopDt, 'r', encoding='utf-8').readlines()]
#idf key words
jieba.analyse.set_idf_path(fileIdfKeyDt)
#idf stop words
jieba.analyse.set_stop_words(fileStopDt)

#step 0 replace punctuation mark
replaTemplDef = '[^A-Z^a-z^0-9^\u4e00-\u9fa5]'
reCompZh = re.compile(replaTemplDef)

#traverse the jd list
for lineJd in listJd:
    strIsB = tfQ2B(lineJd['despInfo'])
    strNoMark = reCompZh.sub('',strIsB)
    #cut wods
    listTextCut = jieba.cut(strNoMark.lower(),cut_all=False)
    #replace stop word
    listValid = []
    for validWord in listTextCut:  
        if validWord not in listMyCutStopWords and len(validWord)>1: 
            listValid.append(validWord)
    strCuted = ''.join(listValid)
    listKeyWords = jieba.analyse.extract_tags(strCuted.lower(),topK=50,withWeight=False)
    print(lineJd['positionName'])
    print(listKeyWords)






import os
import json
import jieba.analyse
import re

'''
格式化字符串，全角转半角
input:str
return:str
author:roy
dt:2019-05-18
'''
def tfQ2B(strOri):
    strB = ''
    #遍历所有字母
    for letter in strOri:
        charCode = ord(letter)
        #全角空格直接转换
        if charCode == 12288:
            charCode = 32
        elif charCode >= 65281 and charCode <= 65374:
            charCode = charCode - 65248
        strB = strB + chr(charCode)
    return strB

#path paramater
fileRootPath = '/Users/roy/MyApp/jd'
fileEnd = '.txt'
fileMinName = 'HangZhou-'
fileName = 'TeachAdmin'
fullPath = fileRootPath + os.sep + fileMinName + fileName + fileEnd

#load file text into a list
listJd = []
strJd = ''
for line in open(fullPath,'r',encoding='utf8'):  
    strRead = line.strip()
    if strRead == '}':
        listJd.append(json.loads(strJd + strRead))
        strJd = ''
    else:
        strJd = strJd + strRead

#load jieba config file
fileCutStopDt = '/Users/roy/Run/jieba-dict/dt_hrjlk_cut_stop_words.dt'
fileStopDt = '/Users/roy/Run/jieba-dict/dt_hrjlk_stop_words.dt'
fileKeyDt = '/Users/roy/Run/jieba-dict/dt_hrjlk_key_words.dt'
fileIdfKeyDt = '/Users/roy/Run/jieba-dict/dt_hrjlk_idf_words.dt'

objJiebaCut = jieba
objJiebaKey = jieba

objJiebaAnlCut = objJiebaCut.analyse
objJiebaAnlKey = objJiebaKey.analyse

#cut word user defiend
jieba.load_userdict(fileKeyDt)
#cut stop words
listMyCutStopWords = [line.split('\n')[0] for line in open(fileCutStopDt, 'r', encoding='utf-8').readlines()]
#idf key words
jieba.analyse.set_idf_path(fileIdfKeyDt)
#idf stop words
jieba.analyse.set_stop_words(fileStopDt)

#step 0 replace punctuation mark
replaTemplDef = '[^A-Z^a-z^0-9^\u4e00-\u9fa5]'
reCompZh = re.compile(replaTemplDef)

#traverse the jd list
for lineJd in listJd:
    strIsB = tfQ2B(lineJd['despInfo'])
    strNoMark = reCompZh.sub('',strIsB)
    #cut wods
    listTextCut = jieba.cut(strNoMark.lower(),cut_all=False)
    #replace stop word
    listValid = []
    for validWord in listTextCut:  
        if validWord not in listMyCutStopWords and len(validWord)>1: 
            listValid.append(validWord)
    strCuted = ''.join(listValid)
    listKeyWords = jieba.analyse.extract_tags(strCuted.lower(),topK=50,withWeight=False)
    print(lineJd['positionName'])
    print(listKeyWords)
