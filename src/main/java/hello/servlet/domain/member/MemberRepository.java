package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
* 동시성 문제가 고려되어 있지 않음
* 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
* */
public class MemberRepository {
    private static Map<Long,Member> store = new HashMap<>();

    private static long sequence = 0L;

    //싱글톤으로 객체 생성
    private static final MemberRepository instance = new MemberRepository();
    public static MemberRepository getInstance(){
        return instance;
    }

    //생성자를 private로 선언 하여 외부에서 생성할수 없도록 만든다.
    private MemberRepository(){
    }


    //저장
    public Member save(Member member){
        member.setId(++sequence); //고유 id 값만 데이터베이스에서 추가하여 저장
        store.put(member.getId(), member);
        return member;
    }

    // 아이디 값으로 찾기
    public Member findById(long id){
        return store.get(id);
    }
    //전체 리스트
    public List<Member> findAll(){
        return new ArrayList<>(store.values()); // store 전체 값들을 새로운 ArrayList에 값을 넣어준다. -- 이유 store 자체 보호
    }

    //전체 데이터 제거
    public void clearStore(){
        store.clear();
    }


}
