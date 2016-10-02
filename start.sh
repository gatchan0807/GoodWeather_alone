#!/bin/sh

if [ -n "$2" ]
then
    FILE_NAME="$2"
elif [ "$1" = "-c" ]
then
    echo '設定したファイル名を入力してください'
    read FILE_NAME
else
    FILE_NAME="jettyServer" # デフォルトサーバファイル名
fi
gradle --daemon war     # 高速ビルドのために --daemon オプション
java -jar build/libs/$FILE_NAME.war
