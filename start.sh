#!/bin/sh

if [ "$1" = "-c" ]
then
    ./gradlew clean
fi

if [ "$1" = "-n" ]
then
    FILE_NAME="$2"
    if [ "$2" = "" ]
    then
        echo '設定したファイル名を入力してください'
        read FILE_NAME
    fi
else
    FILE_NAME="jettyServer" # デフォルトサーバファイル名
fi
./gradlew --daemon war     # 高速ビルドのために --daemon オプション
java -jar build/libs/$FILE_NAME.war
