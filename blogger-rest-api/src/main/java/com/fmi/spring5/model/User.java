package com.fmi.spring5.model;

import java.net.URL;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Document
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	private Long id;
	@NotNull
	public String firstName;
	public String lastName;
	public String email;
	public String password;
	public ROLES role;
	public URL photo;

}
