<#include "security.ftl">

<div class="card">
    <img class="card-img-top" src="/img/${post.photoName}" alt="image">
    <div class="card-body">
        <p class="card-title">${post.description}</p>
        <#if post.owner.id != currentUserId>
            <p class="card-text">Author: ${post.owner.name}</p>
        <#else>
        <form action="/post/${post.id}/update" method="get">
            <button type="submit" class="btn btn-primary">Edit</button>
        </form>
        </#if>
    </div>
</div>
