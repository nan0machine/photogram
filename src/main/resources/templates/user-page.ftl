<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div>
    <@l.logout />
</div>
<h2>${user.name}'s Page</h2>
    <span>Id: <b>${user.id}</b></span>
<br/>
    <span>Name: <b>${user.name}</b></span>
<br/>
    <span>Email: <b>${user.email}</b></span>
</div>
</@c.page>