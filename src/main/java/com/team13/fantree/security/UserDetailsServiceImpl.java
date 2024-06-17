package com.team13.fantree.security;

import com.team13.fantree.entity.User;
import com.team13.fantree.entity.UserStatusEnum;
import com.team13.fantree.exception.MismatchException;
import com.team13.fantree.exception.NotFoundException;
import com.team13.fantree.exception.UserErrorCode;
import com.team13.fantree.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
			.orElseThrow(() -> new NotFoundException(UserErrorCode.USER_NOT_FOUND));
		if (user.getStatus() == UserStatusEnum.NON_USER) {
			throw new MismatchException(UserErrorCode.WITHDRAW_USER);
		}

		return new UserDetailsImpl(user);
	}
}