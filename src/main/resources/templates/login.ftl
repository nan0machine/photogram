<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<h1>Welcome!</h1>
<@l.login "/login" />
<a href="/user/create">Add new user</a>
</@c.page>