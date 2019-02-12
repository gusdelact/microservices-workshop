curl -X POST \
  http://localhost:7777/auth/oauth/token \
  -H 'authorization: Basic YXBsaWNhY2lvbjp1bnNlY3JldG8=' \
  -H 'cache-control: no-cache' \
  -H 'content-type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW' \
  -F grant_type=password \
  -F scope=webclient \
  -F username=john.carnell \
  -F password=password1
