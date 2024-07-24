let school = {

    name: '尚硅谷',

    getName: function () {
        let fn5 = () => {
            console.log(this);
        }
        fn5();
    }

};

school.getName(); // 输出：{ name: '尚硅谷', getName: [Function: getName] }
