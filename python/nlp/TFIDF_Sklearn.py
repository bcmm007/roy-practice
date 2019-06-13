from sklearn.feature_extraction.text import CountVectorizer

corpus = [
    '帮我 查下 明天 北京 天气 怎么样',
    '帮我 查下 今天 北京 天气 好不好',
    '帮我 查询 去 北京 的 火车',
    '帮我 查看 到 上海 的 火车',
    '帮我 查看 特朗普 的 新闻',
    '帮我 看看 有没有 北京 的 新闻',
    '帮我 搜索 上海 有 什么 好玩的',
    '帮我 找找 上海 东方明珠 在哪']

#计算每个词汇在文本中出现的频率
#min_df最小词频，次数不足不认为是关键词
#max_df最大词频，超过了不认为是关键词
#token_pattern，正则，用来过滤词
vectoerizer = CountVectorizer(min_df=1, max_df=3.0, token_pattern='\\b\\w+\\b')
#开始学习原始文档中所有标记的词汇字典
vectoerizer.fit(corpus)
#得到特征词列表
listWordsBag = vectoerizer.get_feature_names()
print(len(listWordsBag))
#字典形式呈现
dictWordsBag = vectoerizer.vocabulary_
#得到文本矩阵
wordsMatrix = vectoerizer.transform(corpus)
print(wordsMatrix.toarray())
# step 5
print("index of `的` is : {}".format(vectoerizer.vocabulary_.get('的')))

'''
开始统计关键词
'''
from sklearn.feature_extraction.text import TfidfTransformer
#一个TFIDF的转换器
tfidfTransformer = TfidfTransformer()
#用矩阵学习
tfidfTransformer.fit(wordsMatrix.toarray())
#查看TFIDF的权重
for idx,word in enumerate(vectoerizer.get_feature_names()):
  print("{}\t{}".format(word,tfidfTransformer.idf_[idx]))
#生成在文本中的权重
tfidf = tfidfTransformer.transform(wordsMatrix)
print(tfidf.toarray())
