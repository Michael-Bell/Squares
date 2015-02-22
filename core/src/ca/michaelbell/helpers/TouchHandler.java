package ca.michaelbell.helpers;

import com.badlogic.gdx.input.GestureDetector;

public class TouchHandler extends GestureDetector {
    public interface DirectionListener {
        void onLeft();

        void onRight();

        void onUp();

        void onDown();

        void reset();

        void pause();
    }

    public TouchHandler(DirectionListener directionListener) {
        super(new DirectionGestureListener(directionListener));
    }

    private static class DirectionGestureListener extends GestureAdapter{
        DirectionListener directionListener;

        public DirectionGestureListener(DirectionListener directionListener){
            this.directionListener = directionListener;
        }

        @Override
        public boolean fling(float velocityX, float velocityY, int button) {
            if(Math.abs(velocityX)>Math.abs(velocityY)){
                if(velocityX>0){
                    directionListener.onRight();
                }else{
                    directionListener.onLeft();
                }
            }else{
                if(velocityY>0){
                    directionListener.onDown();
                }else{
                    directionListener.onUp();
                }
            }
            return super.fling(velocityX, velocityY, button);
        }

        @Override
        public boolean longPress(float x, float y) {
            directionListener.reset();
            return true;
        }

        @Override
        public boolean tap(float x, float y, int count, int button) {
            directionListener.pause();
            return false;
        }
    }

}