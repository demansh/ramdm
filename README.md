# ramdm
This is a Rest API for amdm.ru service. This API performs only read operations.
The API is build with the help of spring boot framework.

### For developer
Build
```shell
mvn clean install
```
Run
```shell
mvn spring-boot:run
```

### API
By default, server runs on a localhost:8080.  
The list of end-points
- `api/v1/search?q=foo&page=42` - return paginated json with search results
- `api/v1/authors/{a_name}` - returns json with author object
- `api/v1/authors/{a_name}/songs/{s_name}/{id}` - return json with song object
- `api/v1/authors/{a_name}/songs/{s_name}/{id}/html` - return html
  representation of the song
