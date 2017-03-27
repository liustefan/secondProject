
(function ($, undefined) {
    var requestIndex = 0;
    $.widget("mvcui.menu", {
        version: "1.0",
        options: {
            appendTo: "body",
            target: "_blank",
            fillSpace: true,
            source: []
        },
        pending: 0,
        _create: function () {
            var self = this;
            this.options.appendTo = self.element[0].id; //default append to this control 
            this.menu = self.element[0];

            this.response = function () {
                return self._response.apply(self, arguments);
            };
            this._initSource();
        },
        destroy: function () {
            this.menu.element.remove();
            $.Widget.prototype.destroy.call(this);
        },

        _setOption: function (key, value) {
            $.Widget.prototype._setOption.apply(this, arguments);
            if (key === "source") {
                this._initSource();
            }
            if (key === "appendTo") {
                this.menu.element.appendTo($(value || "body", this.element[0].ownerDocument)[0]);
            }
            if (key === "disabled" && value && this.xhr) {
                this.xhr.abort();
            }
        },

        _initSource: function () {
            var self = this, array, url;
            if ($.isArray(this.options.source)) {
                array = this.options.source;
                this.source = function (request, response) {
                    response(array);
                };
                //self._response(self.options.source);
            } else if (typeof this.options.source === "string") {
                url = this.options.source;
                this.source = function (request, response) {
                    if (self.xhr) {
                        self.xhr.abort();
                    }
                    self.xhr = $.ajax({
                        url: url,
                        data: request,
                        dataType: "json",
                        autocompleteRequest: ++requestIndex,
                        success: function (data, status) {
                            if (this.autocompleteRequest === requestIndex) {
                                self.options.source = data;
                                self._response(self.options.source);
                            }
                        },
                        error: function () {
                            if (this.autocompleteRequest === requestIndex) {
                                response([]);
                            }
                        }
                    });
                };
            } else {
                this.source = this.options.source;
            }
            this.source(null, this.response);
        },
        _response: function (content) {
            var self = this;
            if (content && content.length && $.isArray(content)) {
                content = this._normalize(content);
                this._suggest(content);

            }
            this.pending--;
            if (!this.pending) {
                this.element.removeClass("ui-autocomplete-loading");
            }
        },

        _normalize: function (items) {
            if (items.length && items[0].name && items[0].items) {
                return items;
            }
            return $.map(items, function (item) {
                if (typeof item === "string") {
                    return { name: item };
                }
                var c = $.extend({
                    name: item.Name,
                    icon: item.Icon
                }, item);
                var child = [];
                if ($.isArray(item.Items)) {
                    $.map(item.Items, function (k) {
                        var o = $.extend({
                            name: k.Lable,
                            css: k.Css,
                            target: k.Target,
                            url: k.Url
                        }, k);
                        child.push(o);
                    });
                }
                c.items = child;
                return c;
            });
        },

        _suggest: function (items) {
            var self = this;
            var ul = $(this.menu).empty().zIndex($(this.element).zIndex() + 1);
            this._renderMenu(ul, items);
            ul.show();
            this._resizeMenu();
            $(self.menu).accordion({
                fillSpace: self.options.fillSpace
            });
        },

        _resizeMenu: function () {
            var ul = $(this.menu);
            ul.outerWidth(Math.max(
			ul.width("").outerWidth(),
			this.element.outerWidth()
		));
        },

        _renderMenu: function (ul, items) {
            var self = this;
            //菜单头
            var menuHead = "";
            $.each(items, function (index, item) {
                menuHead = $("<div style=\"border:0; border-top-left-radius:0; border-top-right-radius:0; border-bottom-left-radius:0; border-bottom-right-radius:0;\"></div>").addClass("icons ui-state-default");
                if (item.icon != undefined) {
                    var img = $("<img></img>");
                    img.attr("src", item.icon);
                    img.attr("height", "16px");
                    img.attr("width", "16px");
                    menuHead.append($("<span></span>").addClass("ui-icon").append(img));
                }
                menuHead.append(item.name);
                //主菜单
                $("<h3 style=\" padding:0; border-top-left-radius:0; border-top-right-radius:0; border-bottom-left-radius:0; border-bottom-right-radius:0;\" class=\"ui-border\"></h3>").append(
                     menuHead
                  ).appendTo(ul);
                //呈现子菜单项
                self._renderItem(ul, item);
            });
        },

        _renderItem: function (ul, item) {
            var self = this;
            var aLink = "";
            //第一层Div
            var firstDiv = $("<div style='padding:5px 0;'></div>").addClass("ui-menu-second-list");
            //第二层Div
            var secondDiv = $("<div style='width: 100%;  height: 100%; overflow: auto;'></div>");

            //循环子菜单项
            $.each(item.items, function (index, childItem) {
                aLink = $("<a></a>");
               

                if (childItem.target != undefined) {
                    aLink.attr("target", childItem.target);
                }
                if (childItem.url != undefined) {
                    aLink.attr("href", childItem.url);
                }

                var itemDiv = $("<span></span>").addClass("ui-menu-second")
                  .bind("click", function () {
                      self._resetSelectedItemCss();
                      $(this).attr("class", "ui-menu-second-select");
                  });

                  if (childItem.style) {
                      aLink.attr("style", childItem.style);
                  }

                if (childItem.items && childItem.items.length) {
                    var thirdDiv = self._renderThirdItem(childItem);
                    if (childItem.expand && childItem.expand === true) {
                        thirdDiv.css("display", "block");
                    } else {
                        thirdDiv.css("display", "none");
                    }

                    itemDiv.append(aLink.text(childItem.name).bind("click", function () {
                        thirdDiv.fadeToggle("fast");
                    }));
                    //添加菜单项
                    secondDiv.append(itemDiv);
                    //添加第三层菜单
                    secondDiv.append(thirdDiv);

                } else {
                    itemDiv.append(aLink.text(childItem.name)).appendTo(secondDiv);
                }

            });
            return firstDiv.append(secondDiv).appendTo(ul);
        },

        _renderThirdItem: function (item) {
            var self = this;
            var aLink = "";
            //第一层Div
            var firstDiv = $("<div style='padding:5px 0;'></div>").addClass("ui-menu-third-list");
            //第二层Div
            var secondDiv = $("<div style='width: 100%; overflow: auto;'></div>");

            //循环子菜单项
            $.each(item.items, function (index, childItem) {
                aLink = $("<a></a>");
                if (childItem.target != undefined) {
                    aLink.attr("target", childItem.target);
                }
                if (childItem.url != undefined) {
                    aLink.attr("href", childItem.url);
                }

                if (childItem.style) {
                    aLink.attr("style", childItem.style);
                }

                $("<span></span>").addClass("ui-menu-third")
                  .bind("click", function () {
                      self._resetSelectedItemCss();
                      $(this).attr("class", "ui-menu-third-select");
                  })
                 .append(aLink.text(childItem.name))
                 .appendTo(secondDiv);
            });
            return firstDiv.append(secondDiv);
        },

        _resetSelectedItemCss: function () {
            $(".ui-menu-second-select").each(function () {
                $(this).attr("class", "ui-menu-second");
            });
            $(".ui-menu-third-select").each(function () {
                $(this).attr("class", "ui-menu-third");
            });
        },

        refresh: function () {
            $(this.element).accordion("refresh");
        }
        ,
        widget: function () {
            return this.menu.element;
        }
    });
} (jQuery));

