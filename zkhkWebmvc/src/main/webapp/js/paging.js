/*
 * 分页
 */
$(function() {
  var prePage = $("#h_pre_page").val(),
    nextPage = $("#h_next_page").val(),
    pageSize = $("#pageSize").val(),
    pageNow = $("#h_page_now").val(),
    totalPage = $("#h_total_page").val(),
    orgId = $("#org_id").val();

  if (pageNow != 1) {
    $("#page-first").css({
      "color": "#333",
      "cursor": "pointer"
    });

    $("#pre span").css({
      "background": "url(../img/arrow-l.png) center no-repeat"
    });

    $("#pre").css({
      "cursor": "pointer"
    });
  }
  // 最后一页时
  if (pageNow == totalPage) {
    $("#page-last").css({
      "color": "#ccc",
      "cursor": "default"
    });

    $("#nex span").css({
      "background": "url(../img/arrow-r-gray.png) center no-repeat",
      "cursor": "default"
    });

    $("#nex").css({
      "cursor": "default"
    });
  }

  $("#pageSize").change(function() {
    var pageSize = $("#pageSize").val();
    $("#h_page_size").attr("value", pageSize);
    $("#h_page_now").attr("value", 1);

    $("#form1").submit();
  });

  $("#page-first").click(function() {
    var pageSize = $("#pageSize").val();
    $("#h_page_size").attr("value", pageSize);
    $("#h_page_now").attr("value", 1);
    if (pageNow == 1) {
      return;
    }
    $("#form1").submit();
  });

  $("#page-last").click(function() {
    var pageSize = $("#pageSize").val();
    $("#h_page_size").attr("value", pageSize);
    $("#h_page_now").attr("value", totalPage);

    if (pageNow == totalPage) {
      return;
    }

    $("#form1").submit();
  });

  $("#pre").click(function() {
    var pageSize = $("#pageSize").val();
    $("#h_page_size").attr("value", pageSize);
    $("#h_page_now").attr("value", prePage);

    if (pageNow == 1) {
      return;
    }

    $("#form1").submit();
  });

  $("#nex").click(function() {
    var pageSize = $("#pageSize").val();
    $("#h_page_size").attr("value", pageSize);
    $("#h_page_now").attr("value", nextPage);

    if (pageNow == totalPage) {
      return;
    }

    $("#form1").submit();
    // window.location =
    // url+"?orgId="+orgId+"&pageNow="+nextPage+"&pageSize=" + pageSize;
  });

  $("#toPage-btn").click(function() {
        var pageSize = $("#pageSize").val(),
          num = $("#toPage").val(),
          reg = /^[1-9]\d*$/,
          topage = $("#toPage");

        if (!reg.test(num)) {
          alert("请输入正确的页码！");
          topage.val(pageNow);
          return false;
        }

        if (+num > +totalPage) {
          alert("超过最大页了！");
          topage.val(pageNow);
          return false;
        }
        $("#h_page_size").attr("value", pageSize);
        $("#h_page_now").attr("value", num);

        $("#form1").submit();
      });
});
