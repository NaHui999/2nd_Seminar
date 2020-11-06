
:fire:두번째 세미나(10/10)
===============================

-:blue_heart: 필수과제 (과제완료:10/30)

:sweat_drops: 에러상황 >> ​ 두번째 세미나 필수 과제 단독으로는 실행이 되는데, 1주차 과제와 함께 붙이면 (전체 합본에서) RecyclerView에서 Recycler_detail로 넘어가는 과정에서 중간에 멈추는 상황이 발생한다. 
어떤 요인이 문제인지 확인이 필요함.

> 두번째 필수 과제 단독 실행은 https://github.com/NaHui999/2nd_Seminar 에 올려두었음. 
>
> > 3주차 과제를 하며 Recylcer fragment를 만들때 appbar를 따로 만들 수 없어, 프래그먼트엔 linear만 배치하였음. grid 와 linear 오가는 심화과제 1또한  위 링크에서 확인 가능함.
> >
> > 

item_list_recycler.xml을 둬서 계속 반복 사용될 아이템 레이아웃을 둔다.
그리고 각 아이템에 들어가는 데이터를 RecyclerData로 두었으며
데이터를 뷰에 넣어주는 역할이 RecyclerViewHolder이고,
아이템 별 뷰 홀더를 생성하고 데이터를 엮는 역할은 RecyclerAdapter이다.

나의 프로필을 Recycler뷰로 만든다음 Adapter에 intent를 추가하여 데이터를 담아 
보내서 Recycler_detail 창을 만들어 자세한 내용을 표시해준다.

```
class MainActivity : AppCompatActivity() {
    private lateinit var RecyclerAdapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RecyclerAdapter = RecyclerAdapter(this)

        main_rcv.adapter = RecyclerAdapter
        main_rcv.layoutManager = LinearLayoutManager(this) //이 레이아웃을 격자형으로든 바꿀 수 있다.

        RecyclerAdapter.data = mutableListOf(
                RecyclerData("이름","나희정","2020/10/1","이름에 대한 자세한 설명"),
                RecyclerData("나이","22","2020/10/2","나이에 대한 자세한 설명"),
                RecyclerData("파트","안드로이드","2020/10/3","파트에 대한 자세한 설명"),
                RecyclerData("GitHub","www.github.com/nahui999","2020/10/4","깃헙에 대한 자세한 설명"),
                RecyclerData("Blog","None","2020/10/5","블로그에 대한 자세한 설명"),
                RecyclerData("Sopt","www.sopt.org","2020/10/6","솝트에 대한 자세한 설명")
        )
        RecyclerAdapter.notifyDataSetChanged()

    }
}
```

위는 recycler 창의 모습. Adapter를 불러온다.

```
override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
    
        val view=LayoutInflater.from(context).inflate(R.layout.item_list_recycler,parent,false)
        return RecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size 
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.onBind(data[position])

        holder.itemView.setOnClickListener{

            val intent=Intent(holder.itemView.context,Activity_Recycler_Detail::class.java)

            intent.putExtra("title",data[position].title)
            intent.putExtra("subtitle",data[position].subTitle)
            intent.putExtra("date",data[position].date)
            intent.putExtra("add",data[position].add)

            startActivity(holder.itemView.context,intent,null)
        }
```

RecyclerAdapter는 onCreateViewHolder와 getItemCount, onBindViewHolder를 필수적으로 오버라이드 해야한다.

```
class RecyclerViewHolder (itemView:View):RecyclerView.ViewHolder(itemView){//val,var하면 선언과 동시에 초기화.
private val title:TextView=itemView.findViewById(R.id.item_title) //바인딩시킴.
    private val subTitle:TextView=itemView.findViewById(R.id.item_subtitle)

    fun onBind(data: RecyclerData){//Recyclerdata.kt가 객체로 들어오게됨.
        title.text=data.title
        subTitle.text=data.subTitle
    }
}
```

recyclerViewHolder는 데이터를 바인딩을 시키는 역할을 한다.

<img src="https://user-images.githubusercontent.com/53042824/97704325-8bd16e00-1af5-11eb-90ee-58d46edcb9b9.png" width="40%">

<img src="https://user-images.githubusercontent.com/53042824/97704344-95f36c80-1af5-11eb-8a33-5364e4e3b66d.png" width="40%">


 -:tiger: : ​심화과제1 ( 완성: 11/1)

 grid와 linear layout을 왔다갔다 할수 있도록 appbar을 추가하여 진행하였음.

> 3주차 과제를 하며 appbar를 fragment에 추가하는 것에 어려움을 겪어 따로 분리하여 repository를 생성함.

> 링크: https://github.com/NaHui999/2nd_Seminar 

<img src="https://user-images.githubusercontent.com/53042824/98339258-c59ef900-204e-11eb-82cd-d620138c7eb6.png" width="40%">

<img src="https://user-images.githubusercontent.com/53042824/98339267-c9328000-204e-11eb-9847-7beb1296d3f5.png" width="40%">




 -:tiger:  :심화과제2 (미완)
