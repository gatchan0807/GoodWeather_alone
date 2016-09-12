# Java Web Server テンプレート

## 使用ツール
- Gradle
- 組み込みJetty Server 9.3.7.RC1
- シェルスクリプト
- IntelliJ IDEA
- Servlet 3

## 概要

Web Servlet3 を使うことが出来る Jetty Webサーバを
簡単に作るためのテンプレート。

## 手順(Ubuntu 14.04 LTS版)
1. `$ sudo apt-get install gradle` で 
gradle 1.4 をインストール
2. このリポジトリをクローン
3. `$ ./start.sh` でシェルスクリプトを起動
4. localhost:8080 にブラウザでアクセス
5. localhost:8080/sample にブラウザでアクセス

## シェルスクリプトについてのマニュアル

./start.sh [オプション] [ファイル名]

    オプション    
    -c 出力後ファイル名（build.gradle:L13）の名前を変更している場合に使用

### シェルスクリプトで実行していること

- プロジェクトのソースコードを war ファイルにコンパイルする
- 出来上がった war ファイルを `java -jar` コマンドで実行する

## メリット

- Jetty を利用しているため、Java Webサーバの中では起動が高速。
- sh ファイルを実行するだけでサーバの再起動ができるためデバックがしやすい

## デメリット
- ブレークポイントを打てない…！？

## IntelliJ の設定によって更にデバッグ高速化

下記のように start.sh を IDEA に登録しておけばボタンひとつでサーバの実行をすることが出来る。
![](./README_IMG/Screenshot from 2016-09-11 12:29:10.png)

![](./README_IMG/Screenshot from 2016-09-11 12:29:22.png)

|項目|値|
|:---|:---|
|Name|任意の名前|
|Script|ルートディレクトリから start.sh までのパス|
|Program_aguments|start.shに与えるオプション・引数（書き出し後ファイル名を変更している場合は必須）|
