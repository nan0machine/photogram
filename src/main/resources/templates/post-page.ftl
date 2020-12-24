<#import "parts/common.ftl" as c>

<@c.page>
<h2>${post.id} Post</h2>
<img src="/img/${post.photoName}">
<div><b>${post.description}</b></div>
<div><b>Author: ${post.owner.name}</b></div>
</@c.page>