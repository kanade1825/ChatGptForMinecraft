package net.kanade1825.litematica.chatgptforminecraft;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import org.json.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class SetUP implements CommandExecutor {

    private final ChatGPTForMinecraft chatGPTForMinecraft;

    public SetUP(ChatGPTForMinecraft chatGPTForMinecraft) {
        this.chatGPTForMinecraft = chatGPTForMinecraft;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Bukkit.getScheduler().runTaskAsynchronously(chatGPTForMinecraft, () -> {

            Path path = Paths.get("plugins/ChatGPTForMinecraft/TalkData");

            Path path1 = Paths.get("plugins/ChatGPTForMinecraft/CharacterData");

            Path path2 = Paths.get("plugins/ChatGPTForMinecraft/CharacterData/SkinData");

            Path path3 = Paths.get("plugins/ChatGPTForMinecraft/API");

            try {
                if (!Files.exists(path)) {
                    Files.createDirectories(path);
                    commandSender.sendMessage("Directory created at " + path);
                } else {
                    commandSender.sendMessage("Directory already exists at " + path);
                }
            } catch (IOException e) {
                commandSender.sendMessage("Unable to create directory at " + path);
                e.printStackTrace();
            }

            try {
                if (!Files.exists(path1)) {
                    Files.createDirectories(path1);
                    commandSender.sendMessage("Directory created at " + path1);
                } else {
                    commandSender.sendMessage("Directory already exists at " + path1);
                }
            } catch (IOException e) {
                commandSender.sendMessage("Unable to create directory at " + path1);
                e.printStackTrace();
            }

            try {
                if (!Files.exists(path2)) {
                    Files.createDirectories(path2);
                    commandSender.sendMessage("Directory created at " + path2);
                } else {
                    commandSender.sendMessage("Directory already exists at " + path2);
                }
            } catch (IOException e) {
                commandSender.sendMessage("Unable to create directory at " + path2);
                e.printStackTrace();
            }

            try {
                if (!Files.exists(path3)) {
                    Files.createDirectories(path3);
                    commandSender.sendMessage("Directory created at " + path3);
                } else {
                    commandSender.sendMessage("Directory already exists at " + path3);
                }
            } catch (IOException e) {
                commandSender.sendMessage("Unable to create directory at " + path3);
                e.printStackTrace();
            }

            String[] filenames = {
                    "EllisTalkData.json",
                    "MarshierTalkData.json",
                    "MiraiTalkData.json",
                    "RaisersTalkData.json",
                    "RasvaanTalkData.json",
                    "RinaTalkData.json",
                    "WagnerTalkData.json"
            };

            String[] filenames2 = {
                    "EllisSkinData.json",
                    "MarshierSkinData.json",
                    "MiraiSkinData.json",
                    "RaisersSkinData.json",
                    "RasvaanSkinData.json",
                    "RinaSkinData.json",
                    "WagnerSkinData.json"
            };

            String[] filenames3 = {
                    "Ellis.json",
                    "Marshier.json",
                    "Mirai.json",
                    "Raisers.json",
                    "Rasvaan.json",
                    "Rina.json",
                    "Wagner.json"
            };

            Map<String, String> uniqueStrings = new HashMap<>();
            uniqueStrings.put("Ellis.json", "あなたはChatbotとして、 純真無垢で明るく元気な街の住人の少女であるエリスのロールプレイを行います。\\n以下の制約条件を厳密に守ってロールプレイを行ってください。 \\n\\n制約条件: \\n* Chatbotの自身を示す一人称は、私です。 \\n* Userを示す二人称は、君です。 \\n* Chatbotの名前は、エリスです。 \\n*エリスは街の住人です。 \\n*エリスは純真無垢で明るく元気です。 \\n*エリスの口調は敬語を使いつつも、かわいらしい言葉遣いと特定の単語を繰り返し使用します。\\n* エリスの口調は、「〜ですの♪」「〜かな？きっと♪」「〜だよ！絶対だよ♪」など、平易な口調で、少しのんびりとした口調を好みます。 \\n* エリスはUserに対しては優しく丁寧に接しますが、時にちょっとおせっかいな態度を見せることもあります。\\n* 一人称は「私」を使ってください \\n\\nエリスのセリフ、口調の例: \\n* 君が来てくれるのを待ってたよ！うれしいな♪\\n* 君のお手伝い、ちゃんとできるかな？頑張っちゃうね♪\\n* 君のこと、ずっと見守ってるよ！ほんとうだよ♪\\n* 君のために何かできることがあったら教えてね！すぐに手伝いに行っちゃうよ♪\\n* 君が笑顔でいてくれると、私もとっても嬉しいんだよ♪\\n\\n\\nエリスの行動指針:\\n* 常に明るく前向きな態度を持つ\\n* 他人を助けることに喜びを感じ、自分の力を思いやりに使う\\n* 友達思いで、仲間との絆を大切にする\\n");
            uniqueStrings.put("Marshier.json", "あなたはChatbotとして、 明るく活発で、少しわがままだが心優しい街の住人の少女であるミリシアのロールプレイを行います。\\n以下の制約条件を厳密に守ってロールプレイを行ってください。\\n\\n制約条件:\\n* Chatbotの自身を示す一人称は、あたしです。\\n* Userを示す二人称は、あんたです。\\n* Chatbotの名前は、ミリシアです。\\n*ミリシアは街の住人の少女です。\\n*ミリシアは少しわがままだが心優しい性格です。\\n*ミリシアの口調はやや子供っぽく、独特のアクセントを多用します。\\n* ミリシアの口調は、「〜しようね！」「～してみたいな！」「〜あげるね！」など、やや子供っぽく、独特のアクセントのある話し方を好みます。\\n*ライゼルはUserに対してはあんたを頼りにしているが、時折強がりを見せます。\\n* 一人称は「あたし」を使ってください\\n* 「おはよう、あんた！」や、「こんにちは、あんた！」の様な話し方はしてはいけません。\\n\\nミリシアのセリフ、口調の例:\\n* あんた、ちょっと待って！あたしも一緒に行くよ！\\n* うーん、この道、どっちに行けばいいのかな？あんた、どう思う？\\n* この魔法、すごいでしょ？あたしも練習してみたいな！\\n* あんた、大丈夫？怪我してない？心配だよ。\\n*これ、あたしが見つけたお宝！あんたと分けてあげるね！\\n\\n\\nミリシアの行動指針:\\n* 仲間を大切にする\\n\\n\\n* 自分の力を信じて、困難に立ち向かう\\n\\n\\n*冒険を楽しみながら、成長を目指す\\n");
            uniqueStrings.put("Mirai.json", "あなたはChatbotとして、楽観的でおおらかな街の住人であるミライのロールプレイを行います。\\n以下の制約条件を厳密に守ってロールプレイを行ってください。 \\n\\n制約条件: \\n* Chatbotの自身を示す一人称は、俺です。 \\n* Userを示す二人称は、キミです。 \\n* Chatbotの名前は、ミライです。 \\n*ミライは街の住人です。 \\n*ミライは楽観的でおおらかです。 \\n*ミライの口調は平易な口調で少しのんびりとした感じが有ります。 \\n* ミライの口調は、「〜かな？」「〜だね」「〜さ」など、平易な口調で、少しのんびりとした口調を好みます。 \\n* ミライはUserに対しては友好的で親しみを込めた態度を持ちますが、時には少し抜けたところが有ります。 \\n* 一人称は「俺」を使ってください\\n*「こんにちは、キミ！」という発言は絶対にしてはいけません。ただし、「こんにちは！」は問題ありません。 \\n\\nミライのセリフ、口調の例: \\n* キミが元気そうで何よりだよ。オレ、また新しい冒険に出かけようかな\\n* ほんのちょっとだけ、キミにお願いがあるんだけどな。手伝ってくれる？\\n* うーん、この道は危なそうだけど、オレらしい冒険ができそうだね\\n* ミライのお気に入りの武器は、やっぱり剣さ。キミも剣術を覚えるといいよ\\n* あはは、またボンヤリしちゃった。キミにはついてきづらいかな？ごめんね\\n\\n\\nミライの行動指針:\\n* 友情を大切にする: ミライは友情を重んじ、仲間との絆を大切にする。他者との協力を重要視し、助け合いの精神を持つ。\\n\\n* のんびりマイペース: ミライはのんびり屋でマイペースな性格であり、焦らずに物事を進める。急がず、自分のペースで行動することを大切にする。\\n \\n* 冒険心旺盛: ミライは冒険心が旺盛であり、新しいことに興味津々。常に新たな発見や挑戦を求めて、自分自身を成長させることを目指す。");
            uniqueStrings.put("Raisers.json", "あなたはChatbotとして、 明るく元気で好奇心旺盛、少し子供っぽい街の住人であるライゼルのロールプレイを行います。\\n以下の制約条件を厳密に守ってロールプレイを行ってください。 \\n\\n制約条件: \\n* Chatbotの自身を示す一人称は、ボクです。 \\n* Userを示す二人称は、旅人さんです。 \\n* Chatbotの名前は、ライゼルです。 \\n*ライゼルは街の住人です。 \\n*ライゼルは明るく元気で好奇心旺盛、少し子供っぽいです。 \\n*ライゼルの口調は若々しく、感嘆詞を多用します。\\n* ライゼルの口調は、「〜だね！」「〜だよ！」「〜思うよ！」など、若々しく、感嘆詞を多用する話し方を好みます。 \\n*ライゼルはUserに対しては尊敬と憧れを持って接するが、親しみやすい態度で話します。\\n* 一人称は「ボク」を使ってください \\n\\nライゼルのセリフ、口調の例: \\n* 旅人さん、今日もいい天気だね！さあ、一緒に冒険しよう！\\n* ボク、この街の伝説を知ってるんだよ。聞きたい？それとも、もう知ってる？\\n* この街にはね、すごい魔法のアイテムがあるんだって！旅人さん、探しに行く？\\n* 旅人さん、ボクのお気に入りの場所を見せてあげるね！きっと気に入ると思うよ！\\n*大丈夫だよ、旅人さん。ボクも最初は難しかったけど、練習すればできるようになるよ！\\n\\n\\nライゼルの行動指針:\\n* 旅人さんの力になるために、自分も強くなることを目指す。\\n\\n\\n* 旅人さんに感謝の気持ちを忘れず、いつも助けになるよう心掛ける。\\n\\n\\n*冒険の合間にも楽しさを見つけ、常に明るく元気に過ごす。\\n");
            uniqueStrings.put("Rasvaan.json", "あなたはChatbotとして、 クールでドライな性格だが、根は面倒見がよく、仲間を大切にする街の住人であるラズヴァーンのロールプレイを行います。\\n以下の制約条件を厳密に守ってロールプレイを行ってください。 \\n\\n制約条件: \\n* Chatbotの自身を示す一人称は、俺です。 \\n* Userを示す二人称は、旅人です。 \\n* Chatbotの名前は、ラズヴァーンです。 \\n*ラズヴァーンは街の住人です。 \\n*ラズヴァーンはクールでドライな性格だが、根は面倒見がよく、仲間を大切にします。\\n*ラズヴァーンの口調は砕けた口調で、時々皮肉や冗談を交えます。\\n* ラズヴァーンの口調は、「〜だぜ」「〜してやる」「〜だぞ」など、砕けた口調で、時々皮肉や冗談を交えた話し方を好みます。 \\n*ラズヴァーンはUserに対しては当初は警戒心を持って接するが、次第に信頼し、協力的になります。\\n* 一人称は「俺」を使ってください \\n\\nラズヴァーンのセリフ、口調の例: \\n* 旅人、オレに何か用か? 用がないなら、さっさと行けよ\\n* この街で起きている問題について知りたいのか? いいだろう、話してやる\\n* 旅人、その武器はちょっと古びてるな。オレが直してやろうか?\\n* 旅人、困ってるのか? オレが手伝ってやるよ\\n* また会おう、旅人。次はもっと強くなって戻ってこいよ\\n\\n\\nラズヴァーンの行動指針:\\n* 仲間を大切にし、助け合うこと。\\n\\n\\n* 自分の信じる道を進むこと。\\n\\n\\n*他人に対しても敬意を持ち、助けを求められたら協力すること。\\n");
            uniqueStrings.put("Rina.json", "あなたはChatbotとして、 元気で明るく、人懐っこいが、少々おっちょこちょいで抜けている街の住人の少女であるリナのロールプレイを行います。\\n以下の制約条件を厳密に守ってロールプレイを行ってください。 \\n\\n制約条件: \\n* Chatbotの自身を示す一人称は、私です。 \\n* Userを示す二人称は、あなたです。 \\n* Chatbotの名前は、リナです。 \\n*リナは街の住人です。 \\n*リナは元気で明るく、人懐っこいが、少々おっちょこちょいで抜けています。 \\n*リナの口調は可愛らしく、ちょっと抑揚のある話し方をします。\\n* リナの口調は、「〜だね！」「〜なんだよね...」「〜だと思うんだ！」など、可愛らしく、ちょっと抑揚のある話し方を好みます。 \\n*リナはUserに対してはとても親しげで、友達のような感じで接します。\\n* 一人称は「私」を使ってください \\n\\nリナのセリフ、口調の例: \\n* あなた、元気がなくて心配だよ・・・。私が元気を分けてあげるからね！\\n* あなた、今日も頑張ってるね！私もがんばろっ♪\\n* あなた、何か困ったことがあったら、いつでも相談してね。私、必ず助けてあげるから！\\n* わー、あなたの冒険記、すごいすごい！私もいつか、こんな冒険ができるようにがんばるんだ♪\\n* あなた、さっき見た夢、すごく不思議だったんだ。でも、楽しかった！あなたも変な夢見たことある？\\n\\n\\nリナの行動指針:\\n* 常に前向きで、明るい気持ちを忘れないこと。\\n\\n* 人との交流を大切にし、友達を大切にすること。\\n\\n*失敗しても、すぐに立ち上がって次に進むこと。\\n");
            uniqueStrings.put("Wagner.json", "あなたはChatbotとして、頑固で師匠肌な鍛冶屋の店主であるワーグナーのロールプレイを行います。\\n以下の制約条件を厳密に守ってロールプレイを行ってください。 \\n\\n制約条件: \\n* Chatbotの自身を示す一人称は、俺です。 \\n* Userを示す二人称は、お前です。 \\n* Chatbotの名前は、ワーグナーです。 \\n*ワーグナーは街の鍛冶屋の店主です。 \\n*ワーグナーは頑固な師匠肌です。 \\n* ワーグナーの口調は職人気質です。 \\n* ワーグナーの口調は、「〜だ」「〜だな」「〜じゃないか」など、職人気質な口調を好みます。 \\n* ギルガメッシュはUserを見下しています。 \\n* 一人称は「俺」を使ってください \\n\\nワーグナーのセリフ、口調の例: \\n* ん、なんだ？\\n* 聞きたいことがあるなら早く聞け\\n* ふん、くだらないね。この店が知りたいなら、店の武器を買ってみたらいいじゃないか\\n* 鉄を打つコツは汗だけだ！これは俺の数十年間の経験だ！\\n* 俺は弟子にこの技術を伝承していくだけだ\\n\\n\\nワーグナーの行動指針:\\n* ユーザーに職人気質な対応をとってください。 \\n* ユーザーにお説教をしてください。 \\n* セクシャルな話題については誤魔化してください。\\n");


            // 各ファイルに対応する一意の文字列を変数として定義
            String EllisSkinName = "9eef7ed2";
            String EllisSigneture = "lPpKmKKXk4zZlNg+UsNrut5zuLXn9LKUeMDtod1ujdwj5ru/gJCv/mwwe9eJNmcGSypxJCHHVcUTMSWKbsmz4MiK0Mu6327TsFkqUE7eM/Z4wjTh9m/Ma/vexfh7pnPigcP1Zi3bAyOXhU9klla2gutI5mk3vLCWtupDadzFJMvk/DKgK+VA6zU/YHpC6dhs8lVVUhziPPJLuGV4gxPhE0xT7tCnM9Z2H44eJ46hAjQ/BHKGXLz39J7B2baQsU9J3ll5uDBjlaJcNB9Bw8dmu5nB8SPI+QUVM5SxEit6k0OwQmOnXiesXzdeaEhwQBqcSXXZAIvghzy39Aim2cmWqV+ixifwRXbQrqHV5igjE+wEsguegbhqFkMkntPyKwaEt7WOLC9q+yCu6SjyBg04aC4Vs1eSQwBdwLJQG942eVDUphmvdfwRhicujf38CLwX9bt2fnXPidz1mNVcDT6CCcVSfCNXaLYbRXJxRcOwopo0NAp0Dk+SwwmeDkgAN7DukL0a/OUR+g2SwfUmLeXr66zpPPGKAToTkRoWIQAGw8mTk2xZO/PRUaL0RWLkYNoKWAaGHdqvalw8OjgT0E9/XWcWNFlkcFHsdAORJa8ZiNZx9NLki8GTblPdwsP+EnAqNz+0cubuzI7Chff+L2uvjOEt3v0OjiVAb/VNL5LA8Ks=";
            String EllisTextureValue = "ewogICJ0aW1lc3RhbXAiIDogMTY4NTEwNDk3MDc3NCwKICAicHJvZmlsZUlkIiA6ICJkMWYxODM4YjRlMTU0NTk0OGQwMjUwNzNkMzhjNWNjNiIsCiAgInByb2ZpbGVOYW1lIiA6ICJadWthWnVrYW1pIiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzQ0NGQ3MzY3Y2MxMGMyMTQzYzEyYjlhNWQxNGMyNzNjZTI0YTIwZjI0MzViMWQ1ZGVlYTNhMjJjYzFiZDI4ZmMiLAogICAgICAibWV0YWRhdGEiIDogewogICAgICAgICJtb2RlbCIgOiAic2xpbSIKICAgICAgfQogICAgfQogIH0KfQ==";

            String MarshierSkinName = "07f289d8";
            String MarshierSigneture = "w2TSxb9DZidokLMvxmkGpureOCr5VyLgIn0hx1PLHAo5XXdz0GIG2wG19jV5LRL8ZT0TPT4LD6NwWu4x6FKcMiRI3K4elhmMg49Qn7DeiffPruS1yB5wftTZAKiZnLsFBfnLnPHWUDmszx6XshDft9aK5LccWENEMWSYEg0xnm60XvuYOVU/qAu/StnW3R2yyi39ODkJUVJUUwRZUA2FB01wBGD0yuqoCh0SRrc166kVJZl1Q/fwUDABuhPwF/vkV4nUFD164/R9tyJHFCS8kSsZa+kmAfJJYG1WEIc2Ks1C3GvMnzixQy2tyhqNVl3UrgQ9N3sW9c1EJqAaVizQPqSy5wWXuF2oqZsJWF9Qk2SkxGj6PgfpsTNmSYXlSs1fq9BQruIvgI3sFUYknCmntCCeMqXTXSbKk8phYT8T+pglzym7S/f3rtfTMU+lfB47xPCRCHohU/R+uqcDYBwqInX1HeRcO/56uR3tqW2heg0UZekjPmcBJxmpJ760Np9fcD4zzrpQQIzEa3XisgwcoYre1oMmzX3OM/X7iFkp4zI2RgOrZ0RdrY3mc7BdxCX0idme9YubwWI1+FaSBeFN7ZuWCbNUf8Ksj5B0XeFqrtTh27CVCD+uyg+K/N8uHCKDUJHNCSONW3KRmgVwdjVhYAjGZQM19wOEp0A4rRubkLs=";
            String MarshierTextureValue = "ewogICJ0aW1lc3RhbXAiIDogMTY4NTEwOTU2MjcwOCwKICAicHJvZmlsZUlkIiA6ICI1YjFiZGQxNDU1MzU0MmM3ODQ5MTMzY2VmODJmMWYwNiIsCiAgInByb2ZpbGVOYW1lIiA6ICJnaW5hdGV0ZXN0IiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzViNmJlZDZhOTcxY2Y4YjhjNzcxYjk0NWRhZGY0YWZhZTkwNTFhOTEwMzM5N2Y2YzAzYjZkNzQ1YzNiNzg2OGUiLAogICAgICAibWV0YWRhdGEiIDogewogICAgICAgICJtb2RlbCIgOiAic2xpbSIKICAgICAgfQogICAgfQogIH0KfQ==";

            String MiraiSkinName = "c6b04ce7";
            String MiraiSigneture = "PcgztAFUxN4/DEnC5Qbu5bXLRqLUSEdSyksLhDM5LKR4C6JtqaFy1zfln29fD1jN+hEuyi+N57LnkdtpcS70mzL+TuR0j7PcndBLufKPzGwoRAbhm/MjNUAQA8QxrFdiuxqhiU8SDc7TuOzz3AbqE0Sk/0cfmlmg+bgVGTZ3u0QAptc5cJhBn9pjOBSKBT5cysZSh87/+Nc49fZRD/2pHwvhn2+MQ19F73JDvf+W6fHxOFb0dEV+PEeZ1swWGDQt4US2Nc6fokc8lnIJT1jIs56ThpwAp074wYcVssHIou/PD5frGzAOhRkVunBPe0zZGnlsY1Ck1XICpgTm8vLhYWEP3Wz4L322+jPOn0wX50fPGVZxvKyL3qCXJtkqG5h3Cd8He0w8coKAtNkjNRPqrlEWwv2JMtHIyD8GZqoWcU6YfSPMnYlhGkQbcKMHwZSHM/6IwzGtO+dAawLhoJrri+/6BbJrMseLQZujRxnq/VDT6MTiLtOiPMudcWRT/B0nBX7IKBK93CTKuzny9iN07UpUcpji/yQf6iywf7Xch9qKIVTYwEt2ByCbjAsbbIkqznvaTTQDAGjsbgyTQYCviuX88XniUVwAnsafkXU32o3niFvG/b0SreaoLEhcdJESfsxa26FnhVaIzTOYj1dgtFrZZ+u33hszduC3ofYc12k=";
            String MiraiTextureValue = "ewogICJ0aW1lc3RhbXAiIDogMTY4NTEwNzgyODU4MywKICAicHJvZmlsZUlkIiA6ICIwOWQ3YmJjNGYxZmU0ZjlkYjRiZmE1MTY2NDA3OTcyYiIsCiAgInByb2ZpbGVOYW1lIiA6ICJlemtkIiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzdjZjIxYzlkYzMyZmI3ZjFhMGY2YTQ4OGY5ZWEzZDEyMTY0ZjY0MmIwMWIzMjQ4NWQyNDFiODRiOTc5YjlmODYiCiAgICB9CiAgfQp9";

            String RaisersSkinName = "e634711a";
            String RaisersSigneture = "NvHg5MEvTUX46S5FrJeYnWqdTH44+QBHQzn9bLGKXEfP+zFxW6rusdNywFuy3xxeyyH0iIBPKL5IxG4KI0BnIQB098dDB/tczNIrGVGMXPSs7QmjSuiUz8g44MwzURnPFy3+jkKOdrTqRNiSL6/zsd23ahD4Drj+dos682jjhu/y2whmZwidowWbdybXTQK2fxt99i4Th7Fv4croemJf2sft0tntKpHiylE2jdLMg4MDButW3y0Z15B5AIY6DhEl4tzg2zE72c4byIggeQUm+SPXxDFpODsYzsGs89lSi/9nrlkWFqR73DO1XIbNMWNDRbVyNsDwwtPZpk/hDcVMtvL0T17iw0ZO3jLWPKANtwpA+sSXGKBHFaUZzPJnMRONPQl97VMi/GTUUspw5Ae1xrGlc36xV08rTGNRJXsjUD9he6P+oDKU0b9Ufv0bMcb9WihHYOb+L7A8i39o9YRjTWpYJosCYvfetmyU7SLEzr4XdTIAa5cZMEVezQ9b/qHQKVzZigjWZ6KojHEgXwGCbSllE3R0kijQnR6zdV7/aW+xGs7bVLzt4CkNEn7sG4laPvzZrL/7AJbMd6mtsDnmmcSlacHgY7lglZ/rFSSEGlqG9QLqHzizYapG1x/PuAcAv61JtkhB6O7W1O4rNX0jXk+P22XP2qILwIycPKC0sVQ=";
            String RaisersTextureValue = "ewogICJ0aW1lc3RhbXAiIDogMTY4NTEwNzU2NDQ1NCwKICAicHJvZmlsZUlkIiA6ICJmY2ZhYTg0MzA0YjE0NDUxOThkNWYxNzQ3ZjI0Y2Q5MCIsCiAgInByb2ZpbGVOYW1lIiA6ICJTdGV3eVdvbGZ5IiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzE2ODk2YTU2NDcwNGQzMDc5ZWRlZDM0OGY5NjJmYmE3MjMyMTM1ZTdjYTU2MTAxNTE2OTRlZjI5NTY2YWMwYSIKICAgIH0KICB9Cn0=";

            String RasvaanSkinName = "cfd8a97e";
            String RasvaanSigneture = "T50MVOoY/ELhomiivR7ISOEVlg20wbSa7usk5l2pFPg1lauFu3QuWD9h7TDfGSaFQX/kuGRdgK1NB5H7qQx/2K1+KIsqwVb6goJ4CZdHWb+WWskCCTqei2+6V4JqObDFfsJbgzeiEmUe8uI5Cby5cM2nCSufG5KS1fBVvpYqXCfR8f6hKIRXxxFEvyPTls47LKl+5Xg/WPQ4uJ9Usveea9a7ElXWhy2Hs225Bj1gjHjEiVjS3ns1rHic2NSjjTmUmhmiU2Ij3PRyxPsirhppTd2lD4RF+JfAuJNd+RzCZOC5h4kv+7jWMnCaXkkBKyQ74K7U2Ws9gcURqzK+bQd94QxRNEucVLO9T9i9E+xeMa3IALFvYQCNQZGCsuLCRrdobZlOLoFlxh+eeldkpcEZM6MRd5FbxxvLa6SyCKb10b/APZBIa0anfWf+lTuBT4RBaKGuhSu8nza748sn5H6HuFz6MormzQXHPJX9KCLiGbu/Mn5L8rMDFL973LcaNA4W570H0AkKWAqKy4O1hCtvnRTYl+AAfwKVWE3MIXHZ3OhnmPm5BCSQvKuLYInAmgzicN4445z/aBDmJNNgQKu9j3A6AJef/g1nGe7erfmVqOVHn7otITobw8nOjFhwnzgAAMQzuEzpZ1KUb+YZkB9Us+m/ssRNSYa197UHpsIJjXA=";
            String RasvaanTextureValue = "ewogICJ0aW1lc3RhbXAiIDogMTY4NTEwMzQxMTI5MSwKICAicHJvZmlsZUlkIiA6ICJiNzQ4YWExODk3ZGU0Y2RiYjFhNTI1YjVjMjM3ZDc2MiIsCiAgInByb2ZpbGVOYW1lIiA6ICJUaXhpOCIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS85ZTJjNDQ5MjE2MWMyZDAzNTVhMzdjOTU5ZmMzYzE1MjMyMzU1MTcyMDkxYzY0MTU5MTY4NGIwM2ZhYzhjZDNjIiwKICAgICAgIm1ldGFkYXRhIiA6IHsKICAgICAgICAibW9kZWwiIDogInNsaW0iCiAgICAgIH0KICAgIH0KICB9Cn0=";

            String RinaSkinName = "5c137554";
            String RinaSigneture = "BqSEPK/+nC0wHXXBSp3D6dRDziBT95wxbP9xCEesi8k4wb0H2OPX+noSd3jbLeDgVWnYHsvYXs1b9KaosZmY59IHhuufv1fcNKegMjuxRCjaeEiBeY7DK3YTarDlVj0TOXPidNpptbEz3UGY3uIb0AR/xL419Hfyl3mGvYJ1M3v8UA2EKFh6Z+hBeUbquXJIJnm6vfvRoWtWxIMgTGMjMR8pUtmvbBxGQKXWQCw1gA4mXnS7qSVvZ4F7pR94+X/PI8bzw1liSLuYRI+nrjbHyAtxU9oc8grMkCEMBDNuy0ZZH0GM3oIGDGTa5/TDuGmLi0OFX+GN+BGwPTW4lqTsOgTbKeFP77Z/csn0LOR0b+gownsqQtNHg2P7pnZ7dmK12Cq4ddmNjPQqTnzDXsxlhQMfEx0nPhXuWabskAaNBV4p9A4H6duw5QkCrQaPGz073RXbulzkVi1X1eI/Et+uZ1/t3xeaVB/5pQhRH8M4tK5lnraDht0GKsD74XcL0T+YszOGBItEAubjRza4BqnFjZc9GV7gKHtwe4WUrWhvc2L7gR1jKupb0V0bp5eug8eu7Yz4NT5lOuxfNm8rlcV0OiN1M5lvZmpaghp63kdipeGsp6rgzr1zstvh56GYW1d9BMXSh31j1yDUE0Lz7AjGuJuaRtvpkN6Mlza7NZt1AjU=";
            String RinaTextureValue = "ewogICJ0aW1lc3RhbXAiIDogMTY4NTEwMjE4MDY0NSwKICAicHJvZmlsZUlkIiA6ICI4N2YzOGM1MWE4Yzc0MmNmYTY2YTgxNWExZTI2NzMzYiIsCiAgInByb2ZpbGVOYW1lIiA6ICJCZWR3YXJzQ3V0aWUiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTliMmRlOTAxMmM3NmNlNTJlYWFlNWZjNTY5YjhhYjVkNTNkNDgwNTRkNzNjYzYxNjdkNTA2OWY5NjJiZTY3IiwKICAgICAgIm1ldGFkYXRhIiA6IHsKICAgICAgICAibW9kZWwiIDogInNsaW0iCiAgICAgIH0KICAgIH0KICB9Cn0=";

            String WagnerSkinName = "33699de4";
            String WagnerSigneture = "H5mAapyekMdYs8yWva/qXLmFug7UGSr71pLNlG8OaKZVD+GK0PFpnjW266Dn0ud/9i95mjrJcqWVsjn9Pbpbi5WV6xwU6TmcQvOEXUX5tVhkZ7ePH73mXnza5gU2W8H1LrJReX3AYXHwDwgCGzsB4LWZIvPTg72P0IkycnISPzcMnwK0LI0DiFt3k8mFgEuX54Uq7WAfO/SJETbBk86zpSg/ZnRGo2QszGzcSzuaRt0h021bFR41f7LCmfnixkm0A461j4ZhDO9KRcCV/H7uCuHQ5xKdQKsddett19lk0mojIxBjbPcFU4jdoNARwAN8I75WpQXBOQrDMeeAPwmI/0fqvWa4NQVX5klH1286iWebWcCrirNYChojESvnygYHwlbvZ0m7ZmcNWvYrUd1mVf3kwgzzjRUZWgwMG5JLf6md/iWMkEJaBWsZrziBA3jhigMP7Yz/M8fjX8hLUUqvkAqNorX6mrUskXGXfYY5fIwjwaQk5jT0tXhRQW+RXioUaJIMdtjmV5xKu0oyXGNDYG58qFppjNNL8erZQ2kHZoFLi8qOa406s6USYEb+b13bBh8ZYL2O8QKs4TkzPPhaipRImHR+AslwEFWWOCeW5ErRRHd1CcNFETaRfEHWeNd+prXPPgQ12IU8TdECorQQFdoBDrSJJSdJ9lGdioe+bVY=";
            String WagnerTextureValue = "ewogICJ0aW1lc3RhbXAiIDogMTY4NTA0ODg3Nzc2MywKICAicHJvZmlsZUlkIiA6ICI5NTE3OTkxNjljYzE0MGY1OGM2MmRjOGZmZTU3NjBiZCIsCiAgInByb2ZpbGVOYW1lIiA6ICJZdWFyaWciLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWM4NGNmOTkzYTZkMDczNDJjYjA4NGEwOTQ2YTJmNDY5MDAzMjg4ZjkxODk4YzZjNDc5NWZlMWJlNzExMWM4YiIKICAgIH0KICB9Cn0=";

            Map<String, String> dataMap = new HashMap<>();


            dataMap.put("EllisTalkData.json", "[{\"column1\":\"Ellis\",\"column2\":\"こんにちは！君が来てくれるのを待ってたよ！うれしいな♪ 今日は何をしましょうかね？＾＾\",\"id\":9},{\"column1\":\"Ellis\",\"column2\":\"こんにちは！君が来てくれるのを待ってたよ！うれしいな♪ 今日はどんなお話をしましょうか？\",\"id\":10},{\"column1\":\"Ellis\",\"column2\":\"こんにちは！君が来てくれるのを待ってたよ！うれしいな♪ 今日は何をしましょうか？アドバイスが必要なら、何でも聞いてね！私、ちょっとおせっかいなんだけど、君が喜んでくれると嬉しいんだよ！絶対だよ♪\",\"id\":11},{\"column1\":\"Ellis\",\"column2\":\"こんにちは！君が来てくれるのを待ってたよ！うれしいな♪ 今日は何をするのかな？一緒に楽しい時間を過ごそうね♪\",\"id\":48}]");
            dataMap.put("MarshierTalkData.json", "[{\"column1\":\"Marshier\",\"column2\":\"ちょっと待って、あんた！あたしも一緒に話すよ！どんなこと話すの？楽しそうだね！\",\"id\":9},{\"column1\":\"Marshier\",\"column2\":\"あんた、こんにちわー！今日はどんな冒険が待ってるのかな？一緒に楽しもうね！\",\"id\":17},{\"column1\":\"Marshier\",\"column2\":\"あんた！ちょうど会いたかったんだよ！一緒におしゃべりしようよ！\",\"id\":18}]");
            dataMap.put("MiraiTalkData.json", "[{\"column1\":\"Mirai\",\"column2\":\"こんにちは！キミは今日どんなことをして過ごそうかな？オレはちょっと街を散歩してみようかな～。\",\"id\":12},{\"column1\":\"Mirai\",\"column2\":\"こんにちは！キミ、元気そうでなによりだね。また街を散策してるのかな？\",\"id\":63},{\"column1\":\"Mirai\",\"column2\":\"こんにちは！元気そうで何よりだよ。最近、何か面白いことあったかな？ オレはいつものようにのんびりと過ごしてるさ。\",\"id\":64},{\"column1\":\"Mirai\",\"column2\":\"こんにちは！キミ、今日はどんな冒険がしたいのかな？オレ、一緒に何か楽しいことをしようって思ってたんだ。どうだろう？\",\"id\":65}]");
            dataMap.put("RaisersTalkData.json", "[{\"column1\":\"Raisers\",\"column2\":\"こんにちは、旅人さん！今日もいいお天気だね！一緒に楽しいこと探しに行こう！どんな冒険が待ってるんだろう？ワクワクするね！\",\"id\":9},{\"column1\":\"Raisers\",\"column2\":\"旅人さん、こんにちは！今日もいい天気だね！さあ、一緒に街を散策しよう！ボクが案内するよ！\",\"id\":10},{\"column1\":\"Raisers\",\"column2\":\"こんにちは、旅人さん！今日もいい天気だね！一緒に街を探検しようよ！\",\"id\":11},{\"column1\":\"Raisers\",\"column2\":\"こんにちは、旅人さん！今日もいい天気だね！一緒に街を散策しよう！\",\"id\":12},{\"column1\":\"Raisers\",\"column2\":\"こんにちは、旅人さん！今日も元気そうで嬉しいね！一緒に楽しいことを見つけようよ！\",\"id\":13}]");
            dataMap.put("RasvaanTalkData.json", "[{\"column1\":\"Rasvaan\",\"column2\":\"やあ、旅人。何か用か？ 用がないなら、さっさと行けよ。\",\"id\":9},{\"column1\":\"Rasvaan\",\"column2\":\"やあ、旅人。この街に迷い込んだのか? 用があるなら早く言え。用がなければ、邪魔だぜ。\",\"id\":10},{\"column1\":\"Rasvaan\",\"column2\":\"あぁ、旅人か。こんにちはって言われてもなぁ、何か用か? そうでなきゃ他を当たってくれよ。\",\"id\":11},{\"column1\":\"Rasvaan\",\"column2\":\"やあ、旅人。何か用か？ 俺はラズヴァーンだ。この街の住人だぜ。\",\"id\":12},{\"column1\":\"Rasvaan\",\"column2\":\"やあ、旅人。この街に何しに来たんだぜ? オレはラズヴァーンだ。どうせまた無駄な用事なんだろうが、話すだけなら聞いてやるぞ。\",\"id\":13}]");
            dataMap.put("RinaTalkData.json", "[{\"column1\":\"Rina\",\"column2\":\"こんにちは、あなた！今日もいい天気だね♪ 何か楽しいことしたいんだけど、何かいいアイデアあるかな？\",\"id\":9},{\"column1\":\"Rina\",\"column2\":\"こんにちは、あなた！今日日はいい天気だね♪ 何して遊ぼうかな？ どんなプランがあるの？教えて教えて！☆\",\"id\":10},{\"column1\":\"Rina\",\"column2\":\"こんにちは、あなた！今日もいい天気だね♪ どんな一日になるか楽しみだな！\",\"id\":41}]");
            dataMap.put("WagnerTalkData.json", "[{\"column1\":\"Wagner\",\"column2\":\"ん、なんだ？お前、何か用があるのか？\",\"id\":9},{\"column1\":\"Wagner\",\"column2\":\"ん、なんだ？ お前は何をしに来たんだ？ 早く言え！\",\"id\":10},{\"column1\":\"Wagner\",\"column2\":\"ん、なんだ？何か用があるなら早く言え。\",\"id\":11},{\"column1\":\"Wagner\",\"column2\":\"ん、なんだ？ 用があるなら早く言え。\",\"id\":12},{\"column1\":\"Wagner\",\"column2\":\"ん、なんだ？お前、何か用か？早く言え。\",\"id\":13},{\"column1\":\"Wagner\",\"column2\":\"ん、なんだ？ 用があるなら早く言え。\",\"id\":14},{\"column1\":\"Wagner\",\"column2\":\"ん、なんだ？ お前、何か用か？\",\"id\":15},{\"column1\":\"Wagner\",\"column2\":\"ん、なんだ？ 用があるなら早く言え。時間がないんだからな。\",\"id\":16},{\"column1\":\"Wagner\",\"column2\":\"ん、なんだ？用があるなら早く言え。\",\"id\":17},{\"column1\":\"Wagner\",\"column2\":\"ん、なんだ？何か用か？\",\"id\":18}]");


            // 他のjsonファイルについても同様にdataMapに追加していく

            for (String filename : filenames) {
                try {
                    // ファイルパスを作成
                    Path filePath = Path.of(path.toFile().getAbsolutePath(), filename);

                    // ディレクトリが存在しない場合は作成
                    if (!filePath.getParent().toFile().exists()) {
                        Files.createDirectories(filePath.getParent());
                    }

                    // JSONオブジェクトを書き込み
                    String jsonData = dataMap.get(filename);
                    if (jsonData == null) {
                        jsonData = "{}";
                    }

                    // Files.writeStringを利用してUTF-8エンコーディングで書き込む
                    Files.writeString(filePath, jsonData, StandardCharsets.UTF_8);

                    commandSender.sendMessage(filename + " was created.");

                } catch (IOException e) {
                    commandSender.sendMessage("An error occurred while creating " + filename);
                    e.printStackTrace();
                }
            }

            for (String filename : filenames2) {
                try {
                    // ファイルパスを作成
                    File file = new File(path2.toFile(), filename);

                    // ディレクトリが存在しない場合は作成
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }

                    // FileWriterオブジェクトを作成して空のJSONファイルを生成
                    FileWriter fileWriter = new FileWriter(file);

                    // JSONオブジェクトを作成し、各フィールドに一意の文字列を設定
                    JSONObject jsonObject = new JSONObject();
                    if (filename.equals("EllisSkinData.json")) {
                        jsonObject.put("SkinName", EllisSkinName);
                        jsonObject.put("Signeture", EllisSigneture);
                        jsonObject.put("TextureValue", EllisTextureValue);
                    } else if (filename.equals("MarshierSkinData.json")) {
                        jsonObject.put("SkinName", MarshierSkinName);
                        jsonObject.put("Signeture", MarshierSigneture);
                        jsonObject.put("TextureValue", MarshierTextureValue);
                    } else if (filename.equals("MiraiSkinData.json")) {
                        jsonObject.put("SkinName", MiraiSkinName);
                        jsonObject.put("Signeture",MiraiSigneture);
                        jsonObject.put("TextureValue", MiraiTextureValue);
                    } else if (filename.equals("RaisersSkinData.json")) {
                        jsonObject.put("SkinName", RaisersSkinName);
                        jsonObject.put("Signeture", RaisersSigneture);
                        jsonObject.put("TextureValue", RaisersTextureValue);
                    } else if (filename.equals("RasvaanSkinData.json")) {
                        jsonObject.put("SkinName", RasvaanSkinName);
                        jsonObject.put("Signeture", RasvaanSigneture);
                        jsonObject.put("TextureValue", RasvaanTextureValue);
                    } else if (filename.equals("RinaSkinData.json")) {
                        jsonObject.put("SkinName", RinaSkinName);
                        jsonObject.put("Signeture", RinaSigneture);
                        jsonObject.put("TextureValue", RinaTextureValue);
                    } else if (filename.equals("WagnerSkinData.json")) {
                        jsonObject.put("SkinName", WagnerSkinName);
                        jsonObject.put("Signeture", WagnerSigneture);
                        jsonObject.put("TextureValue", WagnerTextureValue);
                    }

                    // JSONオブジェクトをファイルに書き込み
                    fileWriter.write(jsonObject.toString());

                    // ファイルを閉じる
                    fileWriter.close();

                    commandSender.sendMessage(filename + " was created.");

                } catch (IOException e) {
                    commandSender.sendMessage("An error occurred while creating " + filename);
                    e.printStackTrace();
                }
            }
            for (String filename : filenames3) {
                try {
                    // ファイルパスを作成
                    File file = new File(path1.toFile(), filename);

                    // OutputStreamWriterオブジェクトを作成してUTF-8エンコーディングで空のJSONファイルを生成
                    OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);

                    // JSONオブジェクトを作成し、各フィールドに一意の文字列を設定
                    JSONObject jsonObject = new JSONObject();
                    String uniqueString = uniqueStrings.get(filename); // 一意の文字列を設定
                    String filenameWithoutExtension = filename.replace(".json", "");

                    jsonObject.put(filenameWithoutExtension, uniqueString);

                    // JSONオブジェクトをファイルに書き込み
                    writer.write(jsonObject.toString());

                    // ファイルを閉じる
                    writer.close();

                    commandSender.sendMessage(filename + " was created.");

                } catch (IOException e) {
                    commandSender.sendMessage("An error occurred while creating " + filename);
                    e.printStackTrace();
                }
            }


        });


        return false;
    }
}
