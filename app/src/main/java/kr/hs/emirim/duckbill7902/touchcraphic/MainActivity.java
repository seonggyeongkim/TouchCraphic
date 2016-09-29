package kr.hs.emirim.duckbill7902.touchcraphic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawShape(getApplicationContext()));
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

                canvas.drawCircle(cx,cy,200,paint);
                paint.setColor(Color.GREEN);
                paint.setStyle(Paint.Style.FILL);//채워진 사각형 모양!
                canvas.drawRect(100,100,300,250,paint);
        }
    }
}
