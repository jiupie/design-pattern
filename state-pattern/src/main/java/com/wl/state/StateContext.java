package com.wl.state;

/**
 * @author 南顾北衫
 */
public class StateContext {
    private final Upstate upSometimesState = new UpSometimesState();
    private final Upstate upOftenState = new UpOftenState();
    private final Upstate upUsuallyState = new UpUsuallyState();
    private final Upstate upAlwaysState = new UpAlwaysState();

    Upstate upstate;

    public StateContext() {
        this.upstate = upSometimesState;
    }

    public Upstate getUpstate() {
        return upstate;
    }

    public void setUpstate(Upstate upstate) {
        this.upstate = upstate;
    }

    public Upstate getUpSometimesState() {
        return upSometimesState;
    }

    public Upstate getUpOftenState() {
        return upOftenState;
    }

    public Upstate getUpUsuallyState() {
        return upUsuallyState;
    }

    public Upstate getUpAlwaysState() {
        return upAlwaysState;
    }

    /**
     * 用户对博客内容的动作-投币
     */
    public void throwCoin() {
        upstate = upSometimesState;
        upstate.stateContext=this;
        upstate.switchState();
    }

    /**
     * 用户对博客内容的动作-点赞
     */
    public void like() {
        upstate = upOftenState;
        upstate.stateContext=this;
        upstate.switchState();
    }

    /**
     * 用户对博客内容的动作-收藏
     */
    public void collect() {
        upstate = upUsuallyState;
        upstate.stateContext=this;
        upstate.switchState();
    }


}
