package com.example.demo;

import static com.example.demo.CredentialDynamicSqlSupport.credential;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

import java.util.List;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController /*implements InitializingBean*/ {
	
	/*@Autowired
	private DataSource dataSource;*/
	
	@Autowired
	private CredentialMapper credentialMapper;
	
	//private NamedParameterJdbcTemplate jdbcTemplate;
	
	//private final String sql = "SELECT username FROM credential";
	
	@RequestMapping(value = "/users", produces = { "application/json" }, method = RequestMethod.GET)
	public List<String> getUsers() {
		List<Credential> credentials = credentialMapper.select(
				select(credential.username)
				.from(credential)
				.build()
				.render(RenderingStrategies.MYBATIS3));
		return credentials.stream().map(Credential::getUsername).collect(Collectors.toList());
	}
	
	/*@Override
	public void afterPropertiesSet() throws Exception {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}*/


}
