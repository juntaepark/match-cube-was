package com.carnival.matchcube.Response;

public class ResponseMessage {
    public static final String LOGIN_SUCCESS = "로그인 성공";
    public static final String EMAIL_NOTFOUND = "존재하지 않는 이메일 입니다.";
    public static final String LOGIN_FAIL = "비밀번호가 맞지 않습니다.";
    public static final String SIGNUP_FAIL = "중복된 이메일 주소 입니다.";
    public static final String READ_USER = "회원 정보 조회 성공";
    public static final String NOT_FOUND_USER = "회원을 찾을 수 없습니다.";
    public static final String CREATED_USER = "회원 가입 성공";
    public static final String UPDATE_USER = "회원 정보 수정 성공";
    public static final String DELETE_USER = "회원 탈퇴 성공";
    public static final String NOT_VALID_CITY_CODE = "유효한 시/도 코드가 아닙니다.";
    public static final String POSSIBLE_TEAM_NAME_STRING = "사용가능한 팀명입니다.";
    public static final String DUPLICATED_TEAM_NAME_STRING = "중복된 팀명입니다.";
    public static final String DUPLICATED_TEAM_IMAGE_URL = "같은 사진으로 등록한 다른 팀이 있습니다.";
    public static final String TOO_LONG_TEAM_NAME_STRING = "팀명은 20글자 이내로 입력해주세요.";
    public static final String SUCCESS = "조회 성공";
    public static final String MAKE_SUCCESS = "팀 생성 성공";
    public static final String INTERNAL_SERVER_ERROR = "서버 내부 에러";
    public static final String DB_ERROR = "데이터베이스 에러";
    public static final String NOT_EXIST_USER = "존재하지 않는 회원입니다";
    public static final String NO_TEAM_USER = "활동팀이 없는 회원입니다";
    public static final String TEAM_SHOW_SUCCESS = "팀 조회 성공";
    public static final String NO_EXIST_TEAMS = "목록에 해당하는 팀이 없습니다";
}