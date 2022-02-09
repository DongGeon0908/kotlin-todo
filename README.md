# Kotlin TODO

### TODO

0. 전반적인 코드 리펙토링 진행
1. Exception 수정 작업 진행
2. WebConfig 수정 진행
3. Page처리 작업 진행
4. Swagger 수정 작업 진행

### TIPS

1. entity 또는 dto 만들떄 constructor or companion object를 사용해서 해당 객체에서 다룬다 -> ex) Member라면, Member에서 생성 로직을 가져감
2. dto는 request와 response를 사용한다.
3. dto를 통해 entity를 만드는 경우에는 dto에 있는 것들을 하나씩 빼서 보낸다
4. 별도의 converter or mapper를 사용하지 않는다