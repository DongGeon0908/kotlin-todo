# Kotlin TODO

### TODO

- [x] 기본적인 CRUD
- [x] 전반적인 코드 리펙토링 진행
- [x] Exception 수정 작업 진행
- [x] WebConfig 수정 진행
- [ ] Page처리 작업 진행
- [ ] Swagger 수정 작업 진행
    - [x] 기본적인 Swagger 리펙토링 진행
    - [ ] Status Code 변경 필요
    - [x] Error code 및 Response 내용추가
    - [ ] response가 data로 박싱되게 사용
- [x] CORS 추가
- [x] API 스펙 변경
- [ ] TEST Code 작성 진행하기
- [ ] 함수형으로 메서드 바꾸기

### TIPS

1. entity 또는 dto 만들떄 constructor or companion object를 사용해서 해당 객체에서 다룬다 -> ex) Member라면, Member에서 생성 로직을 가져감
2. dto는 request와 response를 사용한다.
3. dto를 통해 entity를 만드는 경우에는 dto에 있는 것들을 하나씩 빼서 보낸다
4. 별도의 converter or mapper를 사용하지 않는다
5. API 스펙은 깔끔하게 사용하자!
6. 불필요한 컨버팅을 버리고, 효율성과 가독성을 챙기자!