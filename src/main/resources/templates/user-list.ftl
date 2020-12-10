<#import "parts/common.ftl" as c>

<@c.page>
<h2>Users List</h2>
<#list users as user>
<div>
    <b>ID: ${user.id}</b>
    <span> | ${user.name}</span>
</div>
<#else>
No users
</#list>
</@c.page>