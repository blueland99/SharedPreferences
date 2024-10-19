# SharedPreferences

이 프로젝트는 Android EncryptedSharedPreferences를 사용하여 데이터를 안전하게 암호화하고 저장하는 방법을 보여주는 예제입니다. EncryptedSharedPreferences는 중요한 사용자 정보를 안전하게 보호하기 위해 데이터를 암호화하여 저장하는 기능을 제공합니다.

## 기술 스택

- **언어**: Kotlin
- **UI 프레임워크**: Android XML
- **데이터 저장 방식**: EncryptedSharedPreferences

## 주요 기능

- **암호화된 데이터 저장**: EncryptedSharedPreferences를 사용하여 데이터를 암호화한 후 로컬에 저장합니다. 이를 통해 민감한 사용자 데이터를 안전하게 보호할 수 있습니다.
- **데이터 불러오기**: 암호화된 데이터를 복호화하여 불러옵니다.
- **데이터 삭제**: 특정 키에 저장된 데이터를 안전하게 삭제하거나 전체 데이터를 초기화합니다.
- **간단한 Key-Value 저장**: 기본적인 키-값 쌍을 사용해 데이터를 암호화하고, 안전하게 저장합니다.

## EncryptedSharedPreferences 사용 방식

- **데이터 암호화 및 저장**: EncryptedSharedPreferences를 사용하여 데이터를 AES 암호화 방식으로 안전하게 저장합니다.
- **암호화된 데이터 불러오기**: 암호화된 데이터를 복호화하여 앱에서 안전하게 사용할 수 있습니다.
- **PreferencesManager**: PreferencesManager.kt는 암호화된 SharedPreferences 데이터를 관리하는 유틸리티 클래스입니다. 민감한 데이터를 저장하고 불러오는 모든 로직을 캡슐화하여 관리합니다.