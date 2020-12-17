<#import "parts/common.ftl" as c>

<@c.page>
    <h3>${user.name}</h3>
    <div class="row align-items-center align-items-lg-start mb-5">
        <div class="col-xl-1"></div>
        <div class="col-lg-5 col-md-4">
            <img src="/img/photo1.jpg" class="rounded-circle mx-auto d-block" alt="" width="300" height="300">
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
        <#assign posts = user.posts >
        <#list posts as post>
        <div class="card">
            <img class="card-img-top" src="/img/${post.photoName}" alt="image">
            <div class="card-body">
                <p class="card-title">${post.description}</p>
            </div>
        </div>
        <#else>
        No posts
    </#list>
</div>
</@c.page>


