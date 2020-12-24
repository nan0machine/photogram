<#import "parts/common.ftl" as c>

<@c.page>
<h2>Posts List</h2>
<div class="card-columns">
<#list posts as post>
    <#include "parts/card.ftl">
<#else>
No posts
</#list>
</div>
</@c.page>