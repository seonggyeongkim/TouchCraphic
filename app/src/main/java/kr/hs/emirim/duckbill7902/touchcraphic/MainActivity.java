package kr.hs.emirim.duckbill7902.touchcraphic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    static final int LINE=1,RECT=2,CIRCLE=3;
    int chooseShape=CIRCLE;
     DrawShape ds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ds=new DrawShape(getApplicationContext()); //this -> 메소드 안에서!
        LinearLayout linear = (LinearLayout)findViewById(R.id.linear_view);
        linear.addView(ds);

    }

    public void drawShape(View v){
     switch(v.getId()){
         case R.id.but_line:
             chooseShape=LINE;
             break;
         case R.id.but_rect:
             chooseShape=RECT;
             break;
         case R.id.but_circle:
             chooseShape=CIRCLE;
             break;
     }
        ds.invalidate();//ondraw 다시 호출하는 방법!
    }

    class DrawShape extends View{
        DrawShape(Context context){
            super(context); //default가 없으므로 부모객체에서 가져옴!
        }

        @Override
        protected void onDraw(Canvas canvas) { //이미지나 그림을 그리기 위해 필요한 메소드
                super.onDraw(canvas);
                float cx=getWidth()/2.0f;
                float cy=getHeight()/2.0f;
                Paint paint=new Paint(); //굵기 설정
                paint.setStrokeWidth(4);
                paint.setColor(Color.BLUE);
                paint.setStyle(Paint.Style.STROKE);//빈 원 모양!

                switch (chooseShape){
                    case LINE:
                        paint.setColor(Color.RED);
                        canvas.drawLine(50,100,650,100,paint);
                        break;
                    case RECT:
                        paint.setColor(Color.GREEN);
                        paint.setStyle(Paint.Style.FILL);//채워진 사각형 모양!
                        canvas.drawRect(100,100,300,250,paint);
                        break;
                    case CIRCLE:
                        paint.setStrokeWidth(7);
                        canvas.drawCircle(cx,cy,200,paint);
                        break;
                }


        }
    }
}
