/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
// Toast function
function toast(data)
{
        var notification = JSON.parse(data);
        const main = document.getElementById("toastX");
        if (main) {
                const toast = document.createElement("div");

                const duration = 5000;
                // Auto remove toast
                const autoRemoveId = setTimeout(function () {
                        main.removeChild(toast);
                }, duration + 1000);

                // Remove toast when clicked
                toast.onclick = function (e) {
                        if (e.target.closest(".toast__close")) {
                                main.removeChild(toast);
                                clearTimeout(autoRemoveId);
                        }
                };

                const icon = "fas fa-bell";
                const delay = (duration / 1000).toFixed(2);

                toast.classList.add("toastX", `toast--notification`);
                toast.style.animation = `slideInLeft ease .3s, fadeOut linear 1s ${delay}s forwards`;

                var message = notification.message;
                var url = notification.url;
                toast.innerHTML = `
                <a href="${url}" style="text-decoration:none; display: contents"> 
                    <div class="toast__icon">
                        <i class="${icon}"></i>
                    </div>
                    <div class="toast__body">
                        <h3 class="toast__title">Bạn có thông báo mới</h3>
                        <p class="toast__msg">${message}</p>
                    </div>
                </a>
                    <div class="toast__close">
                        <i class="fas fa-times"></i>
                    </div>
                `;
                main.appendChild(toast);
        }
};

//DateTime display
function updateVietnameseTime()
{
        var elements = document.querySelectorAll('.notification-time');

        for (var i = 0; i < elements.length; i++)
        {
                // Thực hiện các thao tác mong muốn với từng phần tử
                var date = elements[i];
                const datetimeValue = date.getAttribute('datetime');
                const vietnameseDatetime = new Date(datetimeValue + (7 * 60 * 60 * 1000));

                const options = {
                        weekday: 'long',
                        year: 'numeric',
                        month: 'numeric',
                        day: 'numeric'
                };

                const formattedVietnameseDatetime = vietnameseDatetime.toLocaleString('vi-VN', options);

                //const vietnameseTimeElement = document.getElementById('Created_at');
                date.innerHTML = formattedVietnameseDatetime;
        }
};

function unread_notification(count)
{
        if (count > 0)
        {
                //document.getElementById("notification-count").innerHTML = "";
                document.getElementById("notification-count").innerHTML = count;
                $("#notification-count").removeClass("hidden");
        }
};

function setReadCode(code)
{
        $.ajax({
                method: "POST",
                url: "/test/NewServlet",
                data: {code}
        }).done(function ()
        {
                $("#notification-count").addClass("hidden");
        });
}
