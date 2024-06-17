// package com.team13.fantree;
//
// import java.util.Arrays;
// import java.util.List;
//
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Component;
// import org.springframework.transaction.annotation.Transactional;
//
// import com.team13.fantree.entity.Comment;
// import com.team13.fantree.entity.Post;
// import com.team13.fantree.entity.User;
// import com.team13.fantree.repository.CommentRepository;
// import com.team13.fantree.repository.PostRepository;
// import com.team13.fantree.repository.UserRepository;
//
// import jakarta.annotation.PostConstruct;
// import lombok.RequiredArgsConstructor;
//
// @Component
// @RequiredArgsConstructor
// public class InitData {
//
// 	private final UserRepository userRepository;
// 	private final PostRepository postRepository;
// 	private final PasswordEncoder passwordEncoder;
// 	private final CommentRepository commentRepository;
//
// 	@Transactional
// 	@PostConstruct
// 	public void init() {
//
// 		List<User> userList = List.of(
// 			 User.builder()
// 			.username("MODUtripleSS1")
// 			.name("윤서연")
// 			.password(passwordEncoder.encode("1234"))
// 			.email("tripleS1@gmail.com")
// 			.headline("잘 부탁해 WAV")
// 			.build(),
// 		 User.builder()
// 			.username("MODUtripleSS2")
// 			.name("정혜린")
// 			.password(passwordEncoder.encode("1234"))
// 			.email("tripleS2@gmail.com")
// 			.headline("잘 부탁해 WAV")
// 			.build(),
// 		User.builder()
// 			.username("MODUtripleSS3")
// 			.name("이지우")
// 			.password(passwordEncoder.encode("1234"))
// 			.email("tripleS3@gmail.com")
// 			.headline("잘 부탁해 WAV")
// 			.build(),
// 		 User.builder()
// 			.username("MODUtripleSS4")
// 			.name("김채연")
// 			.password(passwordEncoder.encode("1234"))
// 			.email("tripleS4@gmail.com")
// 			.headline("잘 부탁해 WAV")
// 			.build(),
// 		 User.builder()
// 			.username("MODUtripleSS5")
// 			.name("김유연")
// 			.password(passwordEncoder.encode("1234"))
// 			.email("tripleS5@gmail.com")
// 			.headline("잘 부탁해 WAV")
// 			.build(),
// 		User.builder()
// 			.username("MODUtripleSS6")
// 			.name("김수민")
// 			.password(passwordEncoder.encode("1234"))
// 			.email("tripleS6@gmail.com")
// 			.headline("잘 부탁해 WAV")
// 			.build(),
// 		 User.builder()
// 			.username("MODUtripleSS7")
// 			.name("김나경")
// 			.password(passwordEncoder.encode("1234"))
// 			.email("tripleS7@gmail.com")
// 			.headline("잘 부탁해 WAV")
// 			.build(),
// 		 User.builder()
// 			.username("MODUtripleSS8")
// 			.name("공유빈")
// 			.password(passwordEncoder.encode("1234"))
// 			.email("tripleS8@gmail.com")
// 			.headline("잘 부탁해 WAV")
// 			.build(),
// 		 User.builder()
// 			.username("MODUtripleSS9")
// 			.name("카에데")
// 			.password(passwordEncoder.encode("1234"))
// 			.email("tripleS9@gmail.com")
// 			.headline("잘 부탁해 WAV")
// 			.build(),
// 		 User.builder()
// 			.username("MODUtripleSS10")
// 			.name("서다현")
// 			.password(passwordEncoder.encode("1234"))
// 			.email("tripleS10@gmail.com")
// 			.headline("잘 부탁해 WAV")
// 			.build(),
// 	 User.builder()
// 			.username("MODUtripleSS11")
// 			.name("코토네")
// 			.password(passwordEncoder.encode("1234"))
// 			.email("tripleS11@gmail.com")
// 			.headline("잘 부탁해 WAV")
// 			.build(),
// 		 User.builder()
// 			.username("MODUtripleSS12")
// 			.name("곽연지")
// 			.password(passwordEncoder.encode("1234"))
// 			.email("tripleS12@gmail.com")
// 			.headline("잘 부탁해 WAV")
// 			.build(),
// 		 User.builder()
// 			.username("MODUtripleSS13")
// 			.name("니엔")
// 			.password(passwordEncoder.encode("1234"))
// 			.email("tripleS13@gmail.com")
// 			.headline("잘 부탁해 WAV")
// 			.build(),
// 		 User.builder()
// 			.username("MODUtripleSS14")
// 			.name("박소현")
// 			.password(passwordEncoder.encode("1234"))
// 			.email("tripleS14@gmail.com")
// 			.headline("잘 부탁해 WAV")
// 			.build(),
// 		 User.builder()
// 			.username("MODUtripleSS15")
// 			.name("신위")
// 			.password(passwordEncoder.encode("1234"))
// 			.email("tripleS15@gmail.com")
// 			.headline("잘 부탁해 WAV")
// 			.build(),
// 		 User.builder()
// 			.username("MODUtripleSS16")
// 			.name("마유")
// 			.password(passwordEncoder.encode("1234"))
// 			.email("tripleS16@gmail.com")
// 			.headline("잘 부탁해 WAV")
// 			.build(),
// 			User.builder()
// 			.username("MODUtripleSS17")
// 			.name("린")
// 			.password(passwordEncoder.encode("1234"))
// 			.email("tripleS17@gmail.com")
// 			.headline("잘 부탁해 WAV")
// 			.build(),
// 		User.builder()
// 			.username("MODUtripleSS18")
// 			.name("주빈")
// 			.password(passwordEncoder.encode("1234"))
// 			.email("tripleS18@gmail.com")
// 			.headline("잘 부탁해 WAV")
// 			.build(),
// 		User.builder()
// 			.username("MODUtripleSS19")
// 			.name("정하연")
// 			.password(passwordEncoder.encode("1234"))
// 			.email("tripleS19@gmail.com")
// 			.headline("잘 부탁해 WAV")
// 			.build(),
// 		User.builder()
// 			.username("MODUtripleSS20")
// 			.name("박시온")
// 			.password(passwordEncoder.encode("1234"))
// 			.email("tripleS20@gmail.com")
// 			.headline("잘 부탁해 WAV")
// 			.build(),
// 		 User.builder()
// 			.username("MODUtripleSS21")
// 			.name("김채원")
// 			.password(passwordEncoder.encode("1234"))
// 			.email("tripleS21@gmail.com")
// 			.headline("잘 부탁해 WAV")
// 			.build(),
// 		 User.builder()
// 			.username("MODUtripleSS22")
// 			.name("설린")
// 			.password(passwordEncoder.encode("1234"))
// 			.email("tripleS22@gmail.com")
// 			.headline("잘 부탁해 WAV")
// 			.build(),
// 		 User.builder()
// 			.username("MODUtripleSS23")
// 			.name("서아")
// 			.password(passwordEncoder.encode("1234"))
// 			.email("tripleS23@gmail.com")
// 			.headline("잘 부탁해 WAV")
// 			.build(),
// 		 User.builder()
// 			.username("MODUtripleSS24")
// 			.name("지연")
// 			.password(passwordEncoder.encode("1234"))
// 			.email("tripleS24@gmail.com")
// 			.headline("잘 부탁해 WAV")
// 			.build()
// 		);
//
// 		userRepository.saveAll(userList);
//
// 		List<String> postList = Arrays.asList(
// 			"WAV들 배지전쟁 잘 봤어? 내가 X맨이다~! -윤서연-",
// 			"안뇽! 나는 혜린이얌 우리 앞으로 재밌게 소통하자! -정혜린-",
// 			"아까 채연언니 폰 뺐어서 내가 글 올렸거든 ㅋㅋㅋ 다들 속았어? -이지우-",
// 			"채연이의 오.노.추 'Knew Better / Forever Boy' - Ariana Grande",
// 			"닭강정 먹음 -김유연-",
// 			"WAV들 여행갈 때 유연 언니 5명 vs 소현언니 5명 누구랑 갈거야?? -김수민-",
// 			"오늘 상탔어!!!!!!!! WAV에게 고마운게 너무 많아. 음방 1위해서 라이브하고 팬들과 인사하고 티비에서 나오는 이루고 싶었던 것들 이루게해줘서 고마워 ㅠㅠ-김나경-",
// 			"유연 언니랑 밥 먹으러 갈건데 점메추 해줄사람? -공유빈-",
// 			"(배지전쟁) 안봤냐?! -카에데-",
// 			"웨이브 안녕 나 소다야 웨이브가 있기에 우리 트리플에스가 더더욱 빛날 수 있게 되는 것 같아 나에게 이런 소중한 감정을 알려줘서 정말 고마워 다들 잘자 뿅-서다현-",
// 			"코토네 네버 다이 -코토네-",
// 			"연지는_밥_먹는중 냠냠냠 -곽연지-",
// 			"강아지보다 더 강아지 같은 니엔이다! -니엔-",
// 			"웨이브 1위 축하해 ! 1위를 할 수 있게 만들어 준 우리 웨이브 진심으로 너무 고마워 이건 너도 함께 받은 상이니까 같이 뿌듯해해줘 -박소현-",
// 			"안녕하세요 신위에요. 오랜 기다림 끝에 드디어 만났네요! 앞으로 잘 부탁해요>_< -신위-",
// 			"항상 내 마음이 가는 곳은 웨이브라는걸 잊지 말라줘 이건 시작이고 앞으로도 계속 함께 달려가자!! -마유-",
// 			"수트 린 어때?-린-",
// 			"다들 인기가요 샌드위치 먹어봤어? -주빈-",
// 			"육각단 오늘도 화이팅! 육각! -정하연-",
// 			"아까 올라온 ASMR 본사람?! -박시온-",
// 			"한결 자연스러워진 시선 처리-김채원-",
// 			"WAV들 รักคุณ -설린-",
// 			"안녕 안녕 안녕하십니까 민족고대 29학번 서아입니다 !! -서아-",
// 			"WAV와 함께 있다면 이젠 무서울 것 없지! -지연-"
// 		);
//
// 		List<String> commentList = List.of(
// 			"진짜 여긴 24명이 다 개그캐인듯",
// 			"이뻐요",
// 			"사랑해요",
// 			"보고싶어요",
// 			"우와~~~~",
// 			"꺄~~~~~~",
// 			"오늘 무대 너무 멋졌어요! 항상 열심히 하는 모습이 정말 감동이에요.",
// 			"새 앨범 너무 좋아요! 모든 노래가 정말 마음에 들어요.",
// 			"언제나 좋은 음악과 무대로 힘을 주셔서 감사합니다.",
// 			"항상 팬들 위해 노력해줘서 고마워요. 응원할게요!",
// 			"오늘 헤어스타일이 정말 잘 어울려요!",
// 			"안무 정말 완벽했어요. 연습 많이 한 게 느껴졌어요.",
// 			"앞으로도 지금처럼 멋진 모습 기대할게요!",
// 			"언제나 당신을 응원해요. 힘내세요!",
// 			"이번 활동 컨셉이 정말 멋져요. 다음에도 기대할게요.",
// 			"뮤직비디오 너무 잘 나왔어요. 보는 내내 즐거웠어요.",
// 			"이번 주 음악 방송 1위 축하해요! 팬으로서 정말 자랑스러워요.",
// 			"신곡의 라이브 무대 너무 멋졌어요. 목소리가 정말 매력적이에요.",
// 			"당신의 음악 덕분에 힘든 시기를 잘 이겨낼 수 있었어요. 정말 고마워요.",
// 			"매일 당신의 브이로그 보면서 행복을 느껴요. 일상 공유해줘서 고마워요!",
// 			"멤버들끼리 케미가 정말 좋아 보여요. 보는 내내 웃음이 나왔어요.",
// 			"그룹의 퍼포먼스가 너무 완벽해요. 멤버 모두 노력한 게 보여요.",
// 			"항상 건강 챙기세요. 아프지 말고 행복했으면 좋겠어요.",
// 			"너무 무리하지 말고, 쉬는 시간도 꼭 가지길 바래요.",
// 			"앞으로도 쭉 응원할게요. 항상 지금처럼 빛나는 모습 보여주세요!",
// 			"당신 덕분에 매일 행복해요. 앞으로도 함께 할게요.",
// 			"다음 앨범도 정말 기대돼요! 어떤 컨셉일지 벌써 궁금하네요.",
// 			"곧 있을 콘서트도 너무 기대돼요. 직접 볼 수 있어서 설레요.",
// 			"오늘 무대 보고 너무 감동받았어요. 정말 최고였어요.",
// 			"당신의 웃는 모습을 보면 저도 기분이 좋아져요. 항상 웃어요!",
// 			"이 사진 너무 귀여워요! 오늘 하루도 행복하게 보내세요.",
// 			"오늘 올린 글 읽고 정말 힘이 났어요. 좋은 에너지 고마워요.",
// 			"오늘 착장 정말 잘 어울려요. 패션 센스 최고예요!",
// 			"멤버들끼리 찍은 사진 너무 보기 좋아요. 우정이 느껴져요.",
// 			"언제나 최선을 다하는 모습에 감동받아요. 늘 응원해요!",
// 			"힘든 일 있어도 우리가 있으니 힘내요. 사랑해요!"
// 		);
// 		int commentSize = commentList.size();
// 		int userSize = userList.size();
// 		int postSize = postList.size();
//
// 		for (int i = 0; i < postList.size(); i++) {
// 			Post post = postRepository.save(new Post(postList.get(i), userList.get(i % userSize)));
// 			commentRepository.saveAll(List.of(
// 				new Comment(post, userList.get(i % userSize), commentList.get(i % commentSize)),
// 				new Comment(post, userList.get((i + 2) % userSize), commentList.get((i + 3) % commentSize)),
// 				new Comment(post, userList.get((i + 4) % userSize), commentList.get((i + 6) % commentSize)),
// 				new Comment(post, userList.get((i + 6) % userSize), commentList.get((i + 9) % commentSize))
// 			));
// 		}
//
// 	}
// }
