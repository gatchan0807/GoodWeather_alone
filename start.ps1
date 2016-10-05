if ($Args[0] -eq "-c")
{
	.\gradlew.bat clean
}

if ($Args[0] -eq "-n")
{
	$file_name = $Args[1]
	if ($Args[1] -notlike "?*"){
		Read-Host "設定したファイル名を入力してください"
	}
}
else
{
	$file_name="jettyServer"
}

.\gradlew.bat --daemon war
java -jar build\libs\$file_name.war