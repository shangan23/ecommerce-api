# Spring Security Concepts

## Types of Authentication?
- Knowledge Based - username/password
- Possession Based - otp

## Authorization: Whether user can do the action or not?

## Principal: Currently logged in user

## Granted Authority
- Fine grained
- Access control by Feature

## Role
- coarse grained
- Grouping the access

## Filters: Core concept of Servlet technology. Interceptor/Cross cutting

## AuthenticationManager: AuthenticationManagerBuilder to configure what authentication should do inMemory? JPA?

- WebSecurityConfigurerAdapter 
* - @Override configure(AuthenticationManagerBuilder auth)
* - @Override configure(HttpSecurity http)
- PasswordEncoder

## AuthenticationProvider: can have multiple authentication providers like LDAP, OAuth, Custom; `authenticate()` and `supports()`
- UserDetailsService: `loadUserByUserName()`
- UserDetails interface
* - userName
* - password
* - active
* - authorities

## Annotation 
@EnableWebSecurity
 