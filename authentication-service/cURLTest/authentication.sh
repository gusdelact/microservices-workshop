curl -X POST \
  http://localhost:7777/auth/oauth/token \
  -H 'authorization: Basic YXBsaWNhY2lvbjp1bnNlY3JldG8=' \
  -H 'cache-control: no-cache' \
  -H 'content-type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW' \
  -F grant_type=password \
  -F scope=webclient \
  -F username=john.carnell \
  -F password=password1

curl -X POST \
  http://authentication-service-v4-0.127.0.0.1.nip.io/auth/oauth/token \
  -H 'authorization: Basic YXBsaWNhY2lvbjp1bnNlY3JldG8=' \
  -H 'content-type: multipart/form-data' \
  -F grant_type=password \
  -F username=john.carnell \
  -F password=password1
