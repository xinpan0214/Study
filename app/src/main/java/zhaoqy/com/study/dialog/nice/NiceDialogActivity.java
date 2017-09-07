package zhaoqy.com.study.dialog.nice;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import zhaoqy.com.study.R;
import zhaoqy.com.study.utils.SystemBarUtil;

public class NiceDialogActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nice_dialog);
        /**
         * 隐藏标题栏
         */
        //getSupportActionBar().hide();
        SystemBarUtil.setSystemBar(this);

        ImageView back = (ImageView) findViewById(R.id.img_back);
        back.setVisibility(View.VISIBLE);
        back.setOnClickListener(this);

        TextView title = (TextView) findViewById(R.id.tv_title);
        title.setText("NiceDialog");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back: {
                finish();
                break;
            }
        }
    }

    public void showDialog0(View view) {
        NiceDialog.init()
                .setLayoutId(R.layout.nice_dialog_share_layout)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {

                        holder.setOnClickListener(R.id.wechat, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(NiceDialogActivity.this, "分享微信成功", Toast.LENGTH_SHORT).show();
                            }
                        });

                        holder.setOnClickListener(R.id.pengyouquan, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(NiceDialogActivity.this, "分享朋友圈成功", Toast.LENGTH_SHORT).show();
                            }
                        });

                        holder.setOnClickListener(R.id.qq, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(NiceDialogActivity.this, "分享QQ成功", Toast.LENGTH_SHORT).show();
                            }
                        });

                        holder.setOnClickListener(R.id.qqkongjian, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(NiceDialogActivity.this, "分享QQ空间成功", Toast.LENGTH_SHORT).show();
                            }
                        });

                        holder.setOnClickListener(R.id.weibo, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(NiceDialogActivity.this, "分享微博成功", Toast.LENGTH_SHORT).show();
                            }
                        });

                        holder.setOnClickListener(R.id.cancel, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });
                    }
                })
                .setDimAmount(0.3f)
                .setShowBottom(true)
                .show(getSupportFragmentManager());
    }

    public void showDialog1(View view) {
        NiceDialog.init()
                .setLayoutId(R.layout.nice_dialog_friend_set_layout)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {

                    }
                })
                .setShowBottom(true)
                .setHeight(310)
                .show(getSupportFragmentManager());
    }

    public void showDialog2(View view) {
        NiceDialog.init()
                .setLayoutId(R.layout.nice_dialog_commit_layout)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {
                        final EditText editText = holder.getView(R.id.edit_input);
                        editText.post(new Runnable() {
                            @Override
                            public void run() {
                                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                                imm.showSoftInput(editText, 0);
                            }
                        });
                    }
                })
                .setShowBottom(true)
                .show(getSupportFragmentManager());
    }

    public void showDialog3(View view) {
        NiceDialog.init()
                .setLayoutId(R.layout.nice_dialog_ad_layout)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {
                        holder.setOnClickListener(R.id.close, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });
                    }
                })
                .setWidth(210)
                .setOutCancel(false)
                .setAnimStyle(R.style.EnterExitAnimation)
                .show(getSupportFragmentManager());
    }


    public void showDialog4(View view) {
        NiceDialog.init()
                .setLayoutId(R.layout.nice_dialog_loading_layout)
                .setWidth(100)
                .setHeight(100)
                .setDimAmount(0)
                .show(getSupportFragmentManager());
    }

    public void showDialog5(View view) {
        ConfirmDialog.newInstance("1")
                .setMargin(60)
                .setOutCancel(false)
                .show(getSupportFragmentManager());
    }

    public void showDialog6(View view) {
        ConfirmDialog.newInstance("2")
                .setMargin(60)
                .setOutCancel(false)
                .show(getSupportFragmentManager());
    }

    public static class ConfirmDialog extends BaseNiceDialog {
        private String type;

        public static ConfirmDialog newInstance(String type) {
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            ConfirmDialog dialog = new ConfirmDialog();
            dialog.setArguments(bundle);
            return dialog;
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle bundle = getArguments();
            if (bundle == null) {
                return;
            }
            type = bundle.getString("type");
        }

        @Override
        public int intLayoutId() {
            return R.layout.nice_dialog_confirm_layout;
        }

        @Override
        public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {
            if ("1".equals(type)) {
                holder.setText(R.id.title, "提示");
                holder.setText(R.id.message, "您已支付成功！");
            } else if ("2".equals(type)) {
                holder.setText(R.id.title, "警告");
                holder.setText(R.id.message, "您的账号已被冻结！");
            }
            holder.setOnClickListener(R.id.cancel, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            holder.setOnClickListener(R.id.ok, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
        }
    }
}
