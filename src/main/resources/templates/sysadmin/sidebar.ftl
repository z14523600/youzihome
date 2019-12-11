<div id="sidebar" class="sidebar  responsive ace-save-state">
    <script type="text/javascript">
        try{ace.settings.loadState('sidebar')}catch(e){}
    </script>

    <div class="sidebar-shortcuts" id="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
            <button class="btn btn-success">
                <i class="ace-icon fa fa-signal"></i>
            </button>

            <button class="btn btn-info">
                <i class="ace-icon fa fa-pencil"></i>
            </button>

            <button class="btn btn-warning">
                <i class="ace-icon fa fa-users"></i>
            </button>

            <button class="btn btn-danger">
                <i class="ace-icon fa fa-cogs"></i>
            </button>
        </div>

        <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>
        </div>
    </div><!-- /.sidebar-shortcuts -->

    <ul class="nav nav-list">
        <#--main-->
        <li class="active">
            <a href="/sysadmin/main">
                <i class="menu-icon fa fa-tachometer"></i>
                <span class="menu-text"> Home </span>
            </a>

            <b class="arrow"></b>
        </li>

        <#--相册-->
        <li class="">
            <a href="javascript:void(0);" onclick="getHtmlAJ('main_content','/sysadmin/gallery','');">
                <i class="menu-icon fa fa-picture-o"></i>
                <span class="menu-text"> 相册 </span>
            </a>

            <b class="arrow"></b>
        </li>
        <#--留言板-->
        <li class="">
            <a href="gallery.html">
                <i class="menu-icon fa fa-pencil-square-o"></i>
                <span class="menu-text"> 留言板 </span>
            </a>

            <b class="arrow"></b>
        </li>
        <#--日历-->
        <li class="">
            <a href="/sysadmin/calendar">
                <i class="menu-icon fa fa-calendar"></i>
                <span class="menu-text"> 日历 </span>
            </a>

            <b class="arrow"></b>
        </li>

        <#--个人中心-->
        <li class="">
            <a href="gallery.html">
                <i class="menu-icon fa fa-weibo"></i>
                <span class="menu-text"> 个人中心 </span>
            </a>

            <b class="arrow"></b>
        </li>
        <#--用户管理-->
        <li class="">
            <a href="gallery.html">
                <i class="menu-icon fa fa-users"></i>
                <span class="menu-text"> 用户管理 </span>
            </a>

            <b class="arrow"></b>
        </li>
        <#--日志管理-->
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-list"></i>
                <span class="menu-text"> 网站分析 </span>

                <b class="arrow fa fa-angle-down"></b>
            </a>

            <b class="arrow"></b>

            <ul class="submenu">
                <li class="">
                    <a href="tables.html">
                        <i class="menu-icon fa fa-caret-right"></i>
                        日志管理
                    </a>

                    <b class="arrow"></b>
                </li>

                <li class="">
                    <a href="jqgrid.html">
                        <i class="menu-icon fa fa-caret-right"></i>
                        访客信息
                    </a>

                    <b class="arrow"></b>
                </li>
            </ul>
        </li>


    </ul><!-- /.nav-list -->

    <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
        <i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>
</div>
