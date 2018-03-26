## 1、日期-时间选择器

```
DateTimePickerDialog.Builder(this, object : DateTimePickerDialog.IDateTimeListener {
            override fun getValue(year: Int, month: Int, day: Int, hour: Int, minute: Int) {

                ToastUtil.show(this@MainActivity, "$year-$month-$day $hour:$minute")

            }

        }).create().show()
```