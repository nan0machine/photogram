<#import "parts/common.ftl" as c>

<@c.page>
    <h3>${user.name}</h3>
    <div class="row align-items-center align-items-lg-start mb-5">
        <div class="col-xl-1"></div>
        <div class="col-lg-5 col-md-4">
            <img src="/img/profile-icon.jpg" class="rounded-circle mx-auto d-block" alt="" style="max-width: 55%; height: auto;">
        </div>
        <div class="col-lg-5 col-md-7 my-5 px-5">
            <div>
                <h5>Posts: <span class="badge badge-secondary">99</span></h5>
                <h5>Followers: <span class="badge badge-secondary">10321</span></h5>
                <h5>Following: <span class="badge badge-secondary">256</span></h5>
            </div>
            <form action="/user/${user.id}/update" method="get">
                <button type="submit" class="btn btn-primary my-2">Edit Profile</button>
            </form>
            <form action="/post/create" method="get">
                <button type="submit" class="btn btn-primary my-2">Add new post</button>
            </form>
        </div>
    </div>
    <div class="card-columns">
        <#assign posts = user.posts>
        <#list posts as post>
            <#include "parts/card.ftl">
        <#else>
        No posts
    </#list>
    </div>
</@c.page>


