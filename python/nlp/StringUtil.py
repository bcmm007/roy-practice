# -*- coding: utf-8 -*-
import jieba
import re

class StringUtil(Object):
	#声明正则模板
	templSubjectSerial = '(^[0-9]+)[.，、]'    #去除题号，如：1.
    templSubjectScore = '(^[\（\(])([0-9]+)(分)([\)\）])'    #去除分数 如(14分)
    templSubjectFrom = '(^[\（\(])(.+?)([省市])([\)\）])'    #去掉来源
    templSubjectFlag = '[,.;:"!?，。 _　：；！？、．（）]'
    
    '''
    格式化字符串，替换不需要的符号
    input:str
    return:str
    author:roy
    dt:2019-05-18
    '''
    def replaceSubjectTag(strOri):
        strReplaced = re.sub(templSubjectSerial,'',strOri)
        strReplaced = re.sub(templSubjectScore,'',strReplaced)
        strReplaced = re.sub(templSubjectFrom,'',strReplaced)
        strReplaced = re.replace('\n','').replace('\n','').replace('\r','').replace('\r\n','')
        return strReplaced
    
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

    '''
    格式化字符串，半角转全角
    input:str
    return:str
    author:roy
    dt:2019-05-18
    '''
    def tfB2Q(strOri):
        strQ = ''
        #遍历所有字母
        for letter in strOri:
            charCode = ord(letter)
            #全角空格直接转换
            if charCode == 32:
                charCode = 12288
            elif charCode >= 33 and charCode <= 126:
                charCode = charCode + 65248
            strQ = strQ + chr(charCode)
        return strQ