import os

source_dir='/home/vinay/Downloads/pdf/books'
feature_dir='/usr/local/tomcat/webapps/firstWeb/config/feature.txt'
id_dir='/usr/local/tomcat/webapps/firstWeb/config/id.txt'

book_features={}
graph_splitor='\n'
line_splitor='%'
features={'id','bookname','author','classify','alias'}
booknames=[]

with open(id_dir,'r') as id_file:
    try:
        for line in id_file.readlines():
            line=line.replace('\n','')
            array=line.split(line_splitor)
            book_features[int(array[0])]={'bookname':array[1],'author':array[2],'classify':array[3],'alias':array[4]}
            booknames.append(array[1])

    except Exception:
        pass

print(book_features)

for filename in os.listdir(source_dir):
    try:
        if(filename not in booknames):
            _id=len(book_features)
            print(_id,filename)
            author=input('author:')
            classify=input('classify:')
            alias=input('alias:')
            book_features[_id]={'bookname':filename,'author':author,'classify':classify,'alias':alias}
            booknames.append(filename)
    except Exception:
        pass

with open(id_dir,'w') as id_file:
    for _id in range(0,len(book_features)-1):
        line=str(_id)+'%'+book_features[_id]['bookname']+'%'+book_features[_id]['author']+'%'+book_features[_id]['classify']+'%'+book_features[_id]['alias']
        id_file.write(line+'\n')
    _id=len(book_features)-1
    last_line=str(_id)+'%'+book_features[_id]['bookname']+'%'+book_features[_id]['author']+'%'+book_features[_id]['classify']+'%'+book_features[_id]['alias']
    id_file.write(last_line)
    
