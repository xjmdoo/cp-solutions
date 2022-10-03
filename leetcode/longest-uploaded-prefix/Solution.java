class LUPrefix {
    private int video_count = 0;
    private int[] uploaded;
    private int prefix = 0;
    
    public LUPrefix(int n) {
        this.video_count = n;
        this.uploaded = new int[n];
    }
    
    public void upload(int video) {
        this.uploaded[video - 1] = 1;
            for (int i = prefix; i < video_count; i++) {
                if (this.uploaded[i] == 1) {
                    prefix++;
                } else {
                    break;
                }
            }
    }
    
    public int longest() {
        return prefix;
    }
}

