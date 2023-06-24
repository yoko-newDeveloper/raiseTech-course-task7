#!/bin/bash
echo "GET プロフィール取得"
curl 'http://localhost:8080/profiles' -i

echo "\n\n==========="
echo "POST プロフィール登録"
curl 'http://localhost:8080/profiles' \
-H 'Content-Type: application/json' \
-d '{
"name": "ALBA",
"age": 16,
"dateOfBirth": "2003-04-21"
}' -i

echo "\n\n==========="
echo "PATCH プロフィール更新"
curl -X PATCH 'http://localhost:8080/profiles/1' \
--header 'Content-Type: application/json' \
--data-raw '{
"name": "VANILLA",
"age": 5,
"dateOfBirth": "2013-07-06"
}' -i

echo "\n\n==========="
echo "DELETE プロフィール削除"
curl -X DELETE 'http://localhost:8080/profiles/1' -i