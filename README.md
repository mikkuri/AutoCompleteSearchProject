# About Project

## Contents
- 특정 keyword를 파라미터로 받아 해당 keyword와 관련된 자동완성검색어를 호출하는 api를 만든다.
- 파라미터 keyword는 한 번 인코딩한 상태로 넘어온다고 가정한다.
- 자동완성검색어 데이터는 Redis에 저장한다.
- Return 값은 JSONObject이며 score와 value로 이루어져있다.

## Logic
- Redis에 저장되는 자동완성 검색어는 **Key**(검색어), **Value**(해당하는 자동완성검색어), **Score**(우선순위를 결정할 점수)로 이루어져 있다.
- Score는 0-4로 한정하고 있으며, Score가 높은 것이 우선 순위가 높다고 가정한다. (Score에 벗어나는 숫자는 무시한다)
- 노출될 자동완성 검색어를 count로 받아 해당 count만큼 return한다.

## Development Environment
- Java 11
- Redis 6.0.10
- SpringBoot 2.4.5


## Test URI
localhost:8080/auto-complete/api/get?keyword=%EB%AC%B4
