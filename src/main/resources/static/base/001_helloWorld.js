Ext.onReady(//比window.onload靠前执行
    function () {
        //提示框
        // Ext.MessageBox.alert(                     //与传统alert不同，不会停止程序的执行
        //     '标题',
        //     'helloWorld',
        //     function () {
        //         console.info(this);
        //         alert('回调函数');
        //     },
        //     this//this指该函数被谁调用，此处为WINDOW
        // );


        // // 询问框
        // Ext.Msg.confirm(
        //     '提示信息',
        //     '确认删除？',
        //     function (op) {
        //         if (op == 'yes') {
        //             alert('确认');
        //         } else {
        //             alert('取消');
        //         }
        //     }
        // );

        // //输入框
        // Ext.Msg.prompt('标题', '请输入姓名：', function (op, val) {
        //         console.info(op);
        //         console.info(val);
        //     },
        //     this,
        //     true,
        //     '张三');


        Ext.Msg.wait(
            "tips", "process",
            {
                interval: 500, //bar will move fast!
                duration: 50000,
                increment: 15,
                text: 'Updating...',
                scope: this,
                fn: function () {
                    p.updateText('Done!');
                },
                animate: true
            }
        )


        // Ext.Msg.show({
        //     title: 'Address',
        //     msg: 'Please enter your address:',
        //     width: 300,
        //     buttons: Ext.Msg.YESNOCANCEL,
        //     // multiline: true,
        //     // fn: saveAddress,
        //     // animateTarget: 'addAddressBtn',
        //     icon: Ext.window.MessageBox.INFO
        // });
    }
)