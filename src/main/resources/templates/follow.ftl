<#import "parts/common.ftl" as c>
<@c.page>
<h3>${profile.name}</h3>
<div>${type}</div>
<ul class="list-group">
    <#list users as user>
    <li class="list-group-item">
        <a href="/user/${user.id}">${user.getName()}</a>
    </li>
    </#list>
</ul>
</@c.page>